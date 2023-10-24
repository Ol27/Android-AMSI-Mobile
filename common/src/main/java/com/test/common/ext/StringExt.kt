package com.test.common.ext

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class StringExt {

    companion object {
        fun String.toDate(pattern: String): Date? {
            val dateTimeFormat = SimpleDateFormat(pattern, Locale.getDefault())
            try {
                return dateTimeFormat.parse(this)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return null
        }
    }
}