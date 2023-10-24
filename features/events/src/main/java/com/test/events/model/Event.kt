package com.test.events.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Event(
    val name: String,
    val city: String,
    val time: String,
    val dayDate: String,
    val monthDate: String,
    val image: String,
    val weekDay: String,
    val endTime: String,
    val address: String,
    val phone: String,
    val aboutInto: String,
    val dateTime: String
) : Parcelable
