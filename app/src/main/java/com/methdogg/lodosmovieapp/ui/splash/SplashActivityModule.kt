package com.methdogg.lodosmovieapp.ui.splash

import com.methdogg.lodosmovieapp.base.BaseActivity
import com.methdogg.lodosmovieapp.base.BaseViewModel
import com.methdogg.lodosmovieapp.di.module.ActivityModule
import com.methdogg.lodosmovieapp.di.scope.ActivityScope
import com.methdogg.lodosmovieapp.ui.main.MainActivity
import com.methdogg.lodosmovieapp.ui.main.MainViewModel
import dagger.Binds
import dagger.Module

@Module(includes = [ActivityModule::class])
abstract class SplashActivityModule {
    @ActivityScope
    @Binds
    abstract fun bindBaseActivity(activity: SplashActivity): BaseActivity
}
