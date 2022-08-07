package com.example.eventsandschedule.presentation.navigation

sealed class Screen(val route: String) {
    object Events : Screen("events_screen")
    object Schedule : Screen("schedule_screen")
    object EventVideo : Screen("event_video_screen")
}