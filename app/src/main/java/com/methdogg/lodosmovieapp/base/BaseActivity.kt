package com.methdogg.lodosmovieapp.base

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.methdogg.lodosmovieapp.util.DialogHelper
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var dialogHelper: DialogHelper

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayoutId())

        if (savedInstanceState == null)
            initViews()
    }

    protected abstract fun getLayoutId(): Int

    protected abstract fun initViews()
}
