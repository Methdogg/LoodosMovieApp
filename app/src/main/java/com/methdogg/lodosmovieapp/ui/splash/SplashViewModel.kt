package com.methdogg.lodosmovieapp.ui.splash

import androidx.lifecycle.MutableLiveData
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.get
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.methdogg.lodosmovieapp.R
import com.methdogg.lodosmovieapp.base.BaseViewModel
import javax.inject.Inject

class SplashViewModel @Inject constructor() : BaseViewModel() {

    var remoteConfigText = MutableLiveData<String>()

    override fun start() {
        getRemoteConfigText()
    }

    override fun stop() = Unit

    private fun getRemoteConfigText() {
        val remoteConfig = Firebase.remoteConfig

        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600
        }

        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.setDefaultsAsync(R.xml.default_config)

        remoteConfig.fetch().addOnCompleteListener { task ->
            if (task.isSuccessful){
                remoteConfigText.value = remoteConfig["my_text"].asString()
            }
        }
    }
}
