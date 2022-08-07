package com.example.eventsandschedule.common.components

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.eventsandschedule.domain.events.EventItem

class PreviewItemProvider: PreviewParameterProvider<EventItem> {
    override val values = listOf(
        EventItem(
            "1",
            "Lakers vs Nets",
            "Playoff",
            "Today, 10:00 pm",
            "https://www.linux-magazin.de/wp-content/uploads/2020/08/jetpack-compose-icon_RGB.png",
            "PLACE HOLDER"
        )
    ).asSequence()
}