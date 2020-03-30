package com.methdogg.lodosmovieapp.di.module

import com.methdogg.lodosmovieapp.di.scope.ActivityScope
import com.methdogg.lodosmovieapp.ui.main.MainActivity
import com.methdogg.lodosmovieapp.ui.main.MainActivityModule
import com.methdogg.lodosmovieapp.ui.splash.SplashActivity
import com.methdogg.lodosmovieapp.ui.splash.SplashActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    abstract fun bindSplashActivity(): SplashActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity

}