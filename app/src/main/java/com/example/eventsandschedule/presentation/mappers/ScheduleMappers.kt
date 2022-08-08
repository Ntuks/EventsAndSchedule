package com.example.eventsandschedule.presentation.mappers

import com.example.eventsandschedule.domain.schedule.ScheduleItem
import com.example.eventsandschedule.presentation.models.ScheduleItem as UIScheduleItem

fun ScheduleItem.toUIScheduleItem(): UIScheduleItem {
    return UIScheduleItem(id, title, subtitle, date, imageUrl)
}
