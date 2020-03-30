package com.methdogg.lodosmovieapp.ui.main

import com.methdogg.lodosmovieapp.base.BaseActivity
import com.methdogg.lodosmovieapp.base.BaseViewModel
import com.methdogg.lodosmovieapp.di.module.ActivityModule
import com.methdogg.lodosmovieapp.di.scope.ActivityScope
import dagger.Binds
import dagger.Module

@Module(includes = [ActivityModule::class])
abstract class MainActivityModule {
    @ActivityScope
    @Binds
    abstract fun bindBaseActivity(activity: MainActivity): BaseActivity
}
