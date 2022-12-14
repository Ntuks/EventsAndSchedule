package com.example.eventsandschedule.presentation.events

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eventsandschedule.common.utils.Result
import com.example.eventsandschedule.common.utils.format
import com.example.eventsandschedule.common.utils.toDateLong
import com.example.eventsandschedule.domain.events.EventItem
import com.example.eventsandschedule.domain.repository.EventsRepository
import com.example.eventsandschedule.presentation.mappers.topUIEventItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(
    private val eventsRepository: EventsRepository
): ViewModel() {

    var state by mutableStateOf(EventsState())
        private set

    init {
        getEvents()
    }

    private fun getEvents() {
        viewModelScope.launch{
            state = state.copy(
                isLoading = true,
                errorMessage = null
            )
            when(val result = eventsRepository.getEvents()){
                is Result.Error -> {
                    state = state.copy(
                        eventsList = emptyList(),
                        isLoading = false,
                        errorMessage = result.message
                    )
                }
                is Result.Success -> {
                    val data = result.data as List<EventItem>
                    var events = data.map { it.topUIEventItem() }
                    events = events.sortedBy{ it.date.toDateLong() }.mapIndexed { index, item ->
                        // format the date for extra points
                        val formatter = SimpleDateFormat(
                            "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
                            Locale.getDefault()
                        )
                        val date = formatter.parse(item.date)
                        val calendar = Calendar.getInstance().apply { time = date as Date }

                        item.copy(id = index.toString(), date = calendar.format())
                    }
                    state = state.copy(eventsList = events, isLoading = false, errorMessage = null)
                }
            }
        }
    }

    fun viewEventVideo() = Unit
}