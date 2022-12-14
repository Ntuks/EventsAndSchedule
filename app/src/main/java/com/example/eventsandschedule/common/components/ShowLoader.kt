package com.example.eventsandschedule.common.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ShowLoader() {
    Row (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        CircularProgressIndicator(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.CenterVertically)
                .padding(16.dp)
        )
    }
}