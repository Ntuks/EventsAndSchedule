package com.example.eventsandschedule.presentation.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.eventsandschedule.R

sealed class BottomNavItem(
    val route: String,
    @StringRes val titleResId: Int,
    val icon: ImageVector
) {
    object Events : BottomNavItem(
        route = Screen.Events.route,
        titleResId = R.string.screen_title_event,
        icon = Icons.Default.Home
    )

    object Schedule : BottomNavItem(
        route = Screen.Schedule.route,
        titleResId = R.string.screen_title_schedule,
        icon = Icons.Default.Settings
    )
}