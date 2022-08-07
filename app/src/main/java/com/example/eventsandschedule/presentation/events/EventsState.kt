package com.example.eventsandschedule.presentation.events

import com.example.eventsandschedule.presentation.models.EventItem

data class EventsState(
    val eventsList: List<EventItem> = emptyList(),
    val selectedEvent: EventItem? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val endReached: Boolean = false,
    val page: Int = 0
)