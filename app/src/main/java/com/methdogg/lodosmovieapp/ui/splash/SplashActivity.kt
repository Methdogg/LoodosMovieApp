package com.methdogg.lodosmovieapp.ui.splash

import android.content.Intent
import android.os.Handler
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.methdogg.lodosmovieapp.R
import com.methdogg.lodosmovieapp.base.BaseActivity
import com.methdogg.lodosmovieapp.databinding.ActivitySplashBinding
import com.methdogg.lodosmovieapp.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity() {

    private lateinit var viewModel: SplashViewModel

    private lateinit var dataBinding: ActivitySplashBinding

    private lateinit var dataObserver: Observer<String>

    override fun initViews() {
        viewModel = ViewModelProvider(
            this@SplashActivity,
            viewModelFactory
        ).get(SplashViewModel::class.java)

        dataBinding = ActivitySplashBinding.inflate(layoutInflater).apply {
            this.viewModel = viewModel
        }

        dataObserver = Observer {
            textViewRemoteConfig.text = it
            Handler().postDelayed({
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            }, 2000)
        }

        viewModel.remoteConfigText.observe(this, dataObserver)

        viewModel.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.remoteConfigText.removeObserver(dataObserver)
        viewModel.stop()
    }

    override fun getLayoutId(): Int = R.layout.activity_splash

}
