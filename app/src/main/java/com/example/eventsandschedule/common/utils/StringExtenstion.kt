package com.example.eventsandschedule.common.utils

import java.text.SimpleDateFormat
import java.util.Locale
import java.util.Date

fun String.toDateLong(): Long {
    val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
    return (format.parse(this) as Date).time
}