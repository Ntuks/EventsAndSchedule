package com.example.eventsandschedule.presentation.events

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EventVideoScreen(viewModel: EventsViewModel) {

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(bottom = 20.dp)
    ) {
        viewModel.state.selectedEvent?.videoUrl?.let { url -> VideoPlayer(url) }
    }
}