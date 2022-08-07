package com.example.eventsandschedule.di

import com.example.eventsandschedule.BuildConfig
import com.example.eventsandschedule.data.remote.EventsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofitBuilder(): Retrofit.Builder = Retrofit.Builder().apply {
        baseUrl(BuildConfig.API_HOST_URL)
        addConverterFactory(MoshiConverterFactory.create())
    }

    @Singleton
    @Provides
    fun provideEventsApi(): EventsApi = provideRetrofitBuilder().build().create()

}