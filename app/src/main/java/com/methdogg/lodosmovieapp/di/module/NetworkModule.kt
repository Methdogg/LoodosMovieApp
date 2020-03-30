package com.methdogg.lodosmovieapp.di.module

import com.google.gson.internal.GsonBuildConfig
import com.methdogg.lodosmovieapp.BuildConfig
import com.methdogg.lodosmovieapp.network.util.ApiConstants.API_URL
import com.methdogg.lodosmovieapp.network.service.MovieService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

@Module
object NetworkModule {
    private const val NETWORK_CALL_TIME_OUT = 60

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideMovieApi(retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit =
        Retrofit.Builder()
            .baseUrl(API_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor()
                        .apply {
                            level = if (BuildConfig.DEBUG)
                                HttpLoggingInterceptor.Level.BODY
                            else
                                HttpLoggingInterceptor.Level.NONE
                        })
                    .readTimeout(NETWORK_CALL_TIME_OUT.toLong(), TimeUnit.SECONDS)
                    .writeTimeout(NETWORK_CALL_TIME_OUT.toLong(), TimeUnit.SECONDS)
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
}