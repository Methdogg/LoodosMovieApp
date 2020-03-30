package com.methdogg.lodosmovieapp.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.methdogg.lodosmovieapp.di.qualifier.ViewModelKey
import com.methdogg.lodosmovieapp.di.scope.ApplicationScope
import com.methdogg.lodosmovieapp.ui.main.MainViewModel
import com.methdogg.lodosmovieapp.ui.splash.SplashViewModel
import com.methdogg.lodosmovieapp.util.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module(includes = [ApplicationModule::class])
abstract class ViewModelModule {

    @ApplicationScope
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(viewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

}