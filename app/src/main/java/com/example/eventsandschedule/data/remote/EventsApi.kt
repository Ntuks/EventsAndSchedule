package com.example.eventsandschedule.data.remote

import com.example.eventsandschedule.domain.events.EventItem
import retrofit2.http.GET

interface EventsApi {
    @GET("/getEvents")
    suspend fun getEvents(): List<EventItem>
}