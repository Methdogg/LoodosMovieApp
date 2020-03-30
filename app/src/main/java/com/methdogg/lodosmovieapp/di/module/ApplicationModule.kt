package com.methdogg.lodosmovieapp.di.module

import android.content.Context
import com.methdogg.lodosmovieapp.base.BaseApplication
import com.methdogg.lodosmovieapp.di.qualifier.ApplicationContext
import com.methdogg.lodosmovieapp.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @ApplicationContext
    @ApplicationScope
    @Provides
    internal fun provideContext(application: BaseApplication): Context = application

}