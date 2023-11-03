package com.test.app.di

import com.test.data.repository.EventRepositoryImpl
import com.test.data.repository.JobRepositoryImpl
import com.test.data.service.EventMockService
import com.test.data.service.JobMockService
import com.test.domain.repository.EventRepository
import com.test.domain.repository.JobRepository
import org.koin.dsl.module

val dataDi = module {
    single {
        EventMockService()
    }
    single {
        JobMockService()
    }
    single<EventRepository> {
        EventRepositoryImpl(
            eventMockService = get()
        )
    }
    single<JobRepository> {
        JobRepositoryImpl(
            jobMockService = get()
        )
    }
}