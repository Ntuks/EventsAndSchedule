package com.example.eventsandschedule.data.remote

import com.example.eventsandschedule.domain.schedule.ScheduleItem
import retrofit2.http.GET

interface ScheduleApi {
    @GET("/getSchedule")
    suspend fun getSchedule(): List<ScheduleItem>
}