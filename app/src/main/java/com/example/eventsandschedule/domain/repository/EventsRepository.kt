package com.example.eventsandschedule.domain.repository

import com.example.eventsandschedule.common.utils.Result
import com.example.eventsandschedule.domain.events.EventItem

interface EventsRepository {
    suspend fun getEvents(): Result<List<EventItem>>
}