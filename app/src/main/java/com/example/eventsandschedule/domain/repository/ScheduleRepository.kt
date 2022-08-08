package com.example.eventsandschedule.domain.repository

import com.example.eventsandschedule.common.utils.Result
import com.example.eventsandschedule.domain.schedule.ScheduleItem

interface ScheduleRepository {
    suspend fun getSchedule(): Result<List<ScheduleItem>>
}