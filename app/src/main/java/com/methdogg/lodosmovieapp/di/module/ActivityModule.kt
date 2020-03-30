package com.methdogg.lodosmovieapp.di.module

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.methdogg.lodosmovieapp.base.BaseActivity
import com.methdogg.lodosmovieapp.di.qualifier.ActivityContext
import com.methdogg.lodosmovieapp.di.scope.ActivityScope
import com.methdogg.lodosmovieapp.util.DialogHelper
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ActivityModule {
    @ActivityScope
    @Binds
    abstract fun bindAppCompatActivity(activity: BaseActivity): AppCompatActivity

    @ActivityScope
    @Binds
    abstract fun bindActivity(activity: AppCompatActivity): Activity

    @ActivityContext
    @ActivityScope
    @Binds
    abstract fun bindActivityContext(activity: Activity): Context

    companion object {
        @JvmStatic
        @ActivityScope
        @Provides
        fun provideFragmentManager(
            activity: AppCompatActivity
        ): FragmentManager = activity.supportFragmentManager

        @JvmStatic
        @ActivityScope
        @Provides
        fun provideDialogHelper(
            activity: AppCompatActivity,
            fragmentManager: FragmentManager
        ): DialogHelper = DialogHelper(activity, fragmentManager)
    }
}
