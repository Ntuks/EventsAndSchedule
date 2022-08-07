package com.example.eventsandschedule.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ShowLoader() {
    Row (modifier = Modifier.fillMaxSize()){
        CircularProgressIndicator()
    }
}