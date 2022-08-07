package com.example.eventsandschedule.data.repository

import com.example.eventsandschedule.common.utils.Result
import com.example.eventsandschedule.domain.events.EventItem
import com.example.eventsandschedule.domain.repository.EventsRepository

class FakeEventsRepository: EventsRepository {

    private val events = mutableListOf<EventItem>()

    private var shouldReturnNetworkError = false

    override suspend fun getEvents(): Result<List<EventItem>> {
        TODO("Not yet implemented")
    }

}