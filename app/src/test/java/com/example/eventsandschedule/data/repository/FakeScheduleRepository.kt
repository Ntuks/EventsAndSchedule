package com.example.eventsandschedule.data.repository

import com.example.eventsandschedule.common.utils.Result
import com.example.eventsandschedule.domain.schedule.ScheduleItem
import com.example.eventsandschedule.domain.repository.ScheduleRepository

class FakeScheduleRepository: ScheduleRepository {

    private val events = mutableListOf(
        ScheduleItem(
            id = "1",
            title = "Liverpool v Porto",
            subtitle = "UEFA Champions League",
            date = "2022-08-02T01:09:57.087Z",
            imageUrl = "https://firebasestorage.googleapis.com/v0/b/dazn-recruitment/o",
        )
    )

    var shouldReturnNetworkError = false

    override suspend fun getSchedule(): Result<List<ScheduleItem>> {
       return if (!shouldReturnNetworkError) Result.Success(events)
       else Result.Error("Error getting schedule")
    }

}