package com.methdogg.lodosmovieapp.di.component

import com.methdogg.lodosmovieapp.base.BaseApplication
import com.methdogg.lodosmovieapp.di.module.ActivityBindingModule
import com.methdogg.lodosmovieapp.di.module.ApplicationModule
import com.methdogg.lodosmovieapp.di.module.NetworkModule
import com.methdogg.lodosmovieapp.di.module.ViewModelModule
import com.methdogg.lodosmovieapp.di.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@ApplicationScope
@Component(
    modules = [
        AndroidSupportInjectionModule ::class,
        ApplicationModule ::class,
        NetworkModule::class,
        ActivityBindingModule ::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<BaseApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: BaseApplication): ApplicationComponent
    }
}