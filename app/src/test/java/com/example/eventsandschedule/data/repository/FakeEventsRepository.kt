package com.example.eventsandschedule.data.repository

import com.example.eventsandschedule.common.utils.Result
import com.example.eventsandschedule.domain.events.EventItem
import com.example.eventsandschedule.domain.repository.EventsRepository

class FakeEventsRepository: EventsRepository {

    private val events = mutableListOf(
        EventItem(
            id = "0",
            title = "Liverpool v Porto",
            subtitle = "UEFA Champions League",
            date = "2022-08-02T01:09:57.087Z",
            imageUrl = "https://firebasestorage.googleapis.com/v0/b/dazn-recruitment/o",
            videoUrl = "https://firebasestorage.googleapis.com/v0/b/dazn-recruitment/o"
        )
    )

    var shouldReturnNetworkError = false

    override suspend fun getEvents(): Result<List<EventItem>> {
       return if (!shouldReturnNetworkError) Result.Success(events)
       else Result.Error("Error getting events")
    }

}