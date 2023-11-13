package com.test.domain.model

data class Event(
    val id: Long,
    val name: String,
    val city: String,
    val startTime: String,
    val day: String,
    val month: String,
    val image: String,
    val week: String,
    val endTime: String,
    val address: String,
    val phone: String,
    val about: String,
    val dateTime: String,
    val lat: Double = 0.0,
    val lng: Double = 0.0,
    var liked: Boolean = false
)
