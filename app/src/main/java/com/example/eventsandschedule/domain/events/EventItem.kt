package com.example.eventsandschedule.domain.events

data class EventItem(
    val id: String,
    val title: String,
    val subtitle: String,
    val date: String,
    val imageUrl: String,
    val videoUrl: String
)