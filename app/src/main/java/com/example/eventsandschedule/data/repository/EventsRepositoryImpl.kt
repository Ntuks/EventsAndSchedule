package com.example.eventsandschedule.data.repository

import com.example.eventsandschedule.common.utils.Result
import com.example.eventsandschedule.data.remote.EventsApi
import com.example.eventsandschedule.domain.events.EventItem
import com.example.eventsandschedule.domain.repository.EventsRepository
import javax.inject.Inject

class EventsRepositoryImpl @Inject constructor(
    private val apiService: EventsApi
): EventsRepository {

    override suspend fun getEvents(): Result<List<EventItem>> {
        return try {
            Result.Success(
                data = apiService.getEvents()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Result.Error(e.message ?: "An unknown error occurred  trying to get Events.")
        }
    }
}