package com.example.eventsandschedule.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.eventsandschedule.presentation.events.EventVideoScreen
import com.example.eventsandschedule.presentation.events.EventsScreen
import com.example.eventsandschedule.presentation.events.EventsViewModel
import com.example.eventsandschedule.presentation.schedule.ScheduleScreen

@Composable
fun NavigationSetup(navController: NavHostController) {

    val eventsViewModel: EventsViewModel = hiltViewModel()

    NavHost(navController, startDestination = Screen.Events.route) {
        composable(Screen.Events.route) {
            EventsScreen(navController, eventsViewModel)
        }
        composable(Screen.Schedule.route) {
            ScheduleScreen()
        }
        composable(Screen.EventVideo.route) {
            EventVideoScreen(eventsViewModel)
        }
    }
}