package com.example.eventsandschedule.presentation.events

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EventVideoScreen() {

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(bottom = 20.dp)
    ) {
       Text(
           text = "Video will be shown here",
           modifier = Modifier
               .fillMaxSize()
               .padding(16.dp)
               .padding(bottom = 20.dp)
       )
    }
}