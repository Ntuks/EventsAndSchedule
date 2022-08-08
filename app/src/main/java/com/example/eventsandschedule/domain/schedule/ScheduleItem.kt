package com.example.eventsandschedule.domain.schedule

data class ScheduleItem(
    val id: String,
    val title: String,
    val subtitle: String,
    val date: String,
    val imageUrl: String
)