package com.example.eventsandschedule.presentation.models

data class EventItem (
    override val id: String,
    override val title: String,
    override val subtitle: String,
    override val date: String,
    override val imageUrl: String,
    val videoUrl: String
): Item