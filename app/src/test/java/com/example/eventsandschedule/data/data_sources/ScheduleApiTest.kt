package com.example.eventsandschedule.data.data_sources

import androidx.test.filters.SmallTest
import com.example.eventsandschedule.data.remote.ScheduleApi
import com.example.eventsandschedule.domain.schedule.ScheduleItem
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException

@SmallTest
@RunWith(JUnit4::class) 
class ScheduleApiTest {

    private lateinit var service: ScheduleApi
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(ScheduleApi::class.java)
    }

    @Throws(IOException::class)
    private fun enqueueMockResponse(fileName: String) {
        javaClass.classLoader?.let {
            val inputStream = it.getResourceAsStream(fileName)
            val source = inputStream.source().buffer()
            val mockResponse = MockResponse()
            mockResponse.setBody(source.readString(Charsets.UTF_8))
            server.enqueue(mockResponse)
        }
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    @Test
    fun `Get Schedule`() {
        runBlocking {
            // Prepare fake response
            enqueueMockResponse("ScheduleResponse.json")
            //Send Request to the MockServer
            val responseBody = service.getSchedule()
            //Request received by the mock server
            val request = server.takeRequest()
            assertThat(responseBody).isNotNull()
            assertThat(responseBody.first()).isEqualTo(
                ScheduleItem(
                    id = "1",
                    title = "Liverpool v Porto",
                    subtitle = "UEFA Champions League",
                    date = "2022-08-02T01:09:57.087Z",
                    imageUrl = "https://firebasestorage.googleapis.com/v0/b/dazn-recruitment/o",
                )
            )
        }
    }
}