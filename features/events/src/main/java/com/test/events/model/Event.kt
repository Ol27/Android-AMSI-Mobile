package com.test.events.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Event(
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
    var liked: Boolean,
    val lat:  Double = 0.0,
    val lng: Double = 0.0
) : Parcelable
