package com.test.domain.model

data class Job(
    val id: Long,
    val title: String,
    val company: String,
    val salary: String,
    val speciality: String,
    val type: String,
    val holidayDays: Int,
    val benefits: String,
    val workingProcess: String,
    val term: String,
    val qtyAvailable: Int,
    val distance: String,
    val datePublished: String,
    val minutesAgo: String,
    val phoneNumber: String,
    val contactPerson: String,
    val englishLanguage: String,
    val frenchLanguage: String,
    val stressResistance: String,
    val note: String,
    var liked: Boolean = false
)
