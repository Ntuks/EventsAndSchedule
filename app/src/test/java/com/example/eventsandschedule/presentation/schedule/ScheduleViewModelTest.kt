package com.example.eventsandschedule.presentation.schedule

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.eventsandschedule.common.utils.format
import com.example.eventsandschedule.data.repository.FakeScheduleRepository
import com.example.eventsandschedule.presentation.models.ScheduleItem
import com.example.eventsandschedule.presentation.CoroutineDispatcherRule
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*

@ExperimentalCoroutinesApi
class ScheduleViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesDispatcherRule = CoroutineDispatcherRule()

    @Test
    fun `Given API success, getSchedule() should get Schedule Items successfully` () = runTest {
        var item = ScheduleItem(
            id = "0",
            title = "Liverpool v Porto",
            subtitle = "UEFA Champions League",
            date = "2022-08-02T01:09:57.087Z",
            imageUrl = "https://firebasestorage.googleapis.com/v0/b/dazn-recruitment/o",
        )

        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        val date = formatter.parse(item.date)
        val calendar = Calendar.getInstance().apply { time = date as Date }
        item = item.copy(date = calendar.format())
        val expectedScheduleState = ScheduleState(schedule = listOf(item))

        val fakeRepository = FakeScheduleRepository()
        val viewModel = ScheduleViewModel(fakeRepository)

        assertThat(viewModel.state.schedule).isEqualTo(expectedScheduleState.schedule)
    }

    @Test
    fun `Given API error or network issues, getSchedule() should fail Schedule Items` () = runTest {
        val expectedScheduleState = ScheduleState()

        val fakeRepository = FakeScheduleRepository()
        fakeRepository.shouldReturnNetworkError = true
        val viewModel = ScheduleViewModel(fakeRepository)

        assertThat(viewModel.state.schedule).isEqualTo(expectedScheduleState.schedule)
    }

}