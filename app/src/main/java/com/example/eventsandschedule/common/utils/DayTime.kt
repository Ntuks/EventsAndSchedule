package com.example.eventsandschedule.common.utils

import java.text.SimpleDateFormat
import java.util.*

enum class DayTime(val value: String) {
    TODAY("Today"),
    TOMORROW("Tomorrow"),
    YESTERDAY("Yesterday"),
}

fun Calendar.format(): String {
    val calendar = Calendar.getInstance()
    return when(val days = get(Calendar.DAY_OF_YEAR) - calendar.get(Calendar.DAY_OF_YEAR)) {
        -1 -> {
            "${DayTime.YESTERDAY.value} ${
                if (get(Calendar.HOUR_OF_DAY) < 10) "0" + get(Calendar.HOUR_OF_DAY)
                else get(Calendar.HOUR_OF_DAY)
            }:${
                if(get(Calendar.MINUTE) < 10) "0" + get(Calendar.MINUTE)
                else get(Calendar.MINUTE)
            }"
        }
        0 -> "${DayTime.TODAY.value} ${
            if (get(Calendar.HOUR_OF_DAY) < 10) "0" + get(Calendar.HOUR_OF_DAY)
            else get(Calendar.HOUR_OF_DAY)
        }:${
            if(get(Calendar.MINUTE) < 10) "0" + get(Calendar.MINUTE)
            else get(Calendar.MINUTE)
        }"
        1 -> "${DayTime.TOMORROW.value} ${
            if (get(Calendar.HOUR_OF_DAY) < 10) "0" + get(Calendar.HOUR_OF_DAY)
            else get(Calendar.HOUR_OF_DAY)
        }:${
            if(get(Calendar.MINUTE) < 10) "0" + get(Calendar.MINUTE)
            else get(Calendar.MINUTE)
        }"
        2,3,4,5,6 -> "In $days days"
        7 -> "In a week"
        else -> {
            val formatter = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).apply {
                setCalendar(this@format)
            }
            formatter.format(this.time)
        }
    }
}