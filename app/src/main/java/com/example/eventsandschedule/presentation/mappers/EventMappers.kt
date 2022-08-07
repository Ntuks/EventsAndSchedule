package com.example.eventsandschedule.presentation.mappers

import com.example.eventsandschedule.domain.events.EventItem
import com.example.eventsandschedule.presentation.models.EventItem as UIEventItem

fun EventItem.topUIEventItem(): UIEventItem {
    return UIEventItem(id, title, subtitle, date, imageUrl, videoUrl)
}
