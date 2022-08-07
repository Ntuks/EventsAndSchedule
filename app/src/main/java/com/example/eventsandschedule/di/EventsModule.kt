package com.example.eventsandschedule.di

import com.example.eventsandschedule.data.repository.EventsRepositoryImpl
import com.example.eventsandschedule.domain.repository.EventsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class EventsModule {

    @Binds
    @Singleton
    abstract fun provideEventsRepository(
        repository: EventsRepositoryImpl
    ) : EventsRepository
}