package com.example.eventsandschedule.presentation.events

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.eventsandschedule.common.components.Item
import com.example.eventsandschedule.common.components.ShowLoader
import com.example.eventsandschedule.presentation.navigation.Screen

@Composable
fun EventsScreen(
    navController: NavController,
    viewModel: EventsViewModel
) {
    val state = viewModel.state
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(bottom = 20.dp)
    ) {
        if (state.isLoading && state.eventsList.isNotEmpty()){
            ShowLoader()
        }
        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(state.eventsList) { event ->
                Item(
                    item = event,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 16.dp)
                        .clickable(enabled = true) {
                            state.selectedEvent = event
                            navController.navigate(Screen.EventVideo.route) {
                                navController.graph.startDestinationRoute?.let { route ->
                                    popUpTo(route) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
            item {
                if (state.isLoading && state.eventsList.isNotEmpty()) {
                    ShowLoader()
                }
            }
        }
    }
}