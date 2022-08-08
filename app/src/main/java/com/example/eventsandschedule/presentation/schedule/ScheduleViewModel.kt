package com.example.eventsandschedule.presentation.schedule

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eventsandschedule.common.utils.Result
import com.example.eventsandschedule.common.utils.format
import com.example.eventsandschedule.common.utils.toDateLong
import com.example.eventsandschedule.domain.repository.ScheduleRepository
import com.example.eventsandschedule.domain.schedule.ScheduleItem
import com.example.eventsandschedule.presentation.mappers.toUIScheduleItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    private val scheduleRepository: ScheduleRepository
): ViewModel() {

    var state by mutableStateOf(ScheduleState())
        private set

    private var shouldStopRefreshing = false

    init {
        updateSchedule()
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
                    var schedule = data.map { it.toUIScheduleItem() }
                    schedule = schedule.sortedBy{ it.date.toDateLong() }.mapIndexed { index, item ->
                        // format the date for extra points
                        val formatter = SimpleDateFormat(
                            "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
                            Locale.getDefault()
                        )
                        val date = formatter.parse(item.date)
                        val calendar = Calendar.getInstance().apply { time = date as Date }

                        item.copy(id = index.toString(), date = calendar.format())
                    }
                    state = state.copy(schedule =  schedule, isLoading = false, errorMessage = null)
                }
            }
        }
    }

    private fun updateSchedule() {
        viewModelScope.launch{
            val thirtySeconds = 30000L
            while(!shouldStopRefreshing) {
                getSchedule()
                delay(thirtySeconds)
            }
        }
    }
}