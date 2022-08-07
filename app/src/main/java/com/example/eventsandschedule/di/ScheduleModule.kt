package com.example.eventsandschedule.di

import com.example.eventsandschedule.data.repository.ScheduleRepositoryImpl
import com.example.eventsandschedule.domain.repository.ScheduleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class ScheduleModule {

    @Binds
    @Singleton
    abstract fun provideEventsRepository(
        repository: ScheduleRepositoryImpl
    ) : ScheduleRepository
}