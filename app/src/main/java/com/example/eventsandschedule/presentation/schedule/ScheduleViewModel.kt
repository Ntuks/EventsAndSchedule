package com.example.eventsandschedule.presentation.schedule

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eventsandschedule.common.utils.Result
import com.example.eventsandschedule.domain.repository.ScheduleRepository
import com.example.eventsandschedule.common.utils.toDateLong
import com.example.eventsandschedule.domain.schedule.ScheduleItem
import com.example.eventsandschedule.presentation.mappers.toUIScheduleItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    private val scheduleRepository: ScheduleRepository
): ViewModel() {

    var state by mutableStateOf(ScheduleState())
        private set

    init {
        getSchedule()
    }

    private fun getSchedule() {
        viewModelScope.launch{
            state = state.copy(
                isLoading = true,
                errorMessage = null
            )
            when(val result = scheduleRepository.getSchedule()){
                is Result.Error -> {
                    state = state.copy(
                        schedule = emptyList(),
                        isLoading = false,
                        errorMessage = result.message
                    )
                }
                is Result.Success -> {
                    val data = result.data as List<ScheduleItem>
                    val schedule = data.map { it.toUIScheduleItem() }
                    schedule.sortedBy{ it.date.toDateLong() }.map {
                        // format the date for extra points
                    }
                    state = state.copy(schedule =  schedule, isLoading = false, errorMessage = null)
                }
            }
        }
    }

    fun viewEventVideo() = Unit
}