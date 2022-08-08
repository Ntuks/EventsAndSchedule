package com.example.eventsandschedule.presentation.events

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.eventsandschedule.common.utils.format
import com.example.eventsandschedule.data.repository.FakeEventsRepository
import com.example.eventsandschedule.data.repository.FakeScheduleRepository
import com.example.eventsandschedule.presentation.CoroutineDispatcherRule
import com.example.eventsandschedule.presentation.models.EventItem
import com.example.eventsandschedule.presentation.schedule.ScheduleState
import com.example.eventsandschedule.presentation.schedule.ScheduleViewModel
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*

@ExperimentalCoroutinesApi
class EventsViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesDispatcherRule = CoroutineDispatcherRule()

    @Test
    fun `Given API success, getEvents should get Event Items successfully` () = runTest {
        var item = EventItem(
            id = "0",
            title = "Liverpool v Porto",
            subtitle = "UEFA Champions League",
            date = "2022-08-02T01:09:57.087Z",
            imageUrl = "https://firebasestorage.googleapis.com/v0/b/dazn-recruitment/o",
            videoUrl = "https://firebasestorage.googleapis.com/v0/b/dazn-recruitment/o"
        )

        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        val date = formatter.parse(item.date)
        val calendar = Calendar.getInstance().apply { time = date as Date }
        item = item.copy(date = calendar.format())
        val expectedEventsState = EventsState(eventsList = listOf(item))

        val fakeRepository = FakeEventsRepository()
        val viewModel = EventsViewModel(fakeRepository)

        assertThat(viewModel.state.eventsList).isEqualTo(expectedEventsState.eventsList)
    }

    @Test
    fun `Given API error OR network issues, getEvents should fail to get Event Items`() = runTest {
        val expectedEventsState = EventsState()

        val fakeRepository = FakeEventsRepository()
        fakeRepository.shouldReturnNetworkError = true
        val viewModel = EventsViewModel(fakeRepository)

        assertThat(viewModel.state.eventsList).isEqualTo(expectedEventsState.eventsList)
    }

}