package com.example.eventsandschedule.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.eventsandschedule.presentation.events.EventVideoScreen
import com.example.eventsandschedule.presentation.events.EventsScreen

@Composable
fun NavigationSetup(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Events.route) {
        composable(Screen.Events.route) {
            EventsScreen(navController)
        }
        composable(Screen.Schedule.route) {
            EventsScreen(navController)
        }
        composable(Screen.EventVideo.route) {
            EventVideoScreen()
        }
    }
}