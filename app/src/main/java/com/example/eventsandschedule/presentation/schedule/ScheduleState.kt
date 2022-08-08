package com.example.eventsandschedule.presentation.schedule

import com.example.eventsandschedule.presentation.models.ScheduleItem

data class ScheduleState(
    val schedule: List<ScheduleItem> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val endReached: Boolean = false,
    val page: Int = 0
)