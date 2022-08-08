package com.example.eventsandschedule.presentation.schedule

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
import com.example.eventsandschedule.common.components.Item
import com.example.eventsandschedule.common.components.ShowLoader

@Composable
fun ScheduleScreen(
    viewModel: ScheduleViewModel = hiltViewModel()
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
        if (state.isLoading && state.schedule.isNotEmpty()){
            ShowLoader()
        }
        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(state.schedule) { scheduleItem ->
                Item(
                    item = scheduleItem,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 16.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
            item {
                if (state.isLoading){
                    ShowLoader()
                }
            }
        }
    }
}