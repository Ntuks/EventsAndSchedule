package com.example.eventsandschedule.presentation.events

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.eventsandschedule.presentation.components.Item
import com.example.eventsandschedule.presentation.navigation.Screen

@Composable
fun EventsScreen(
    navController: NavController,
    viewModel: EventsViewModel = hiltViewModel()
) {
    val state = viewModel.state
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(bottom = 20.dp)
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(state.eventsList) { event ->
                Item(
                    event = event,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 16.dp)
                        .clickable {
                            navController.navigate(Screen.EventVideo.route){
                                navController.graph.startDestinationRoute?.let { route ->
                                    popUpTo(route) {
                                        saveState = true
                                    }
                                }
                                // Avoid multiple copies of the same destination when re-selecting the same item
                                launchSingleTop = true
                                // Restore state when re-selecting a previously selected item
                                restoreState = true
                            }
                        },
                )
                Spacer(modifier = Modifier.height(10.dp))

            }
        }
    }
}