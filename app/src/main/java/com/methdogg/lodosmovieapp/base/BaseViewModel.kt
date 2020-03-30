package com.methdogg.lodosmovieapp.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    open lateinit var disposable: Disposable

    abstract fun start()

    abstract fun stop()
}