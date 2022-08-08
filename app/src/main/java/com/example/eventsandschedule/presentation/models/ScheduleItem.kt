package com.example.eventsandschedule.presentation.models

data class ScheduleItem (
    override val id: String,
    override val title: String,
    override val subtitle: String,
    override val date: String,
    override val imageUrl: String
): Item