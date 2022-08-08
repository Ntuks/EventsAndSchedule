package com.example.eventsandschedule.data.repository

import com.example.eventsandschedule.common.utils.Result
import com.example.eventsandschedule.data.remote.ScheduleApi
import com.example.eventsandschedule.domain.schedule.ScheduleItem
import com.example.eventsandschedule.domain.repository.ScheduleRepository
import javax.inject.Inject

class ScheduleRepositoryImpl @Inject constructor(
    private val apiService: ScheduleApi
): ScheduleRepository {

    override suspend fun getSchedule(): Result<List<ScheduleItem>> {
        return try {
            Result.Success(
                data = apiService.getSchedule()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Result.Error(e.message ?: "An unknown error occurred trying to get schedule.")
        }
    }
}