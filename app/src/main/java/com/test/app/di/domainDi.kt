package com.test.app.di

import com.test.domain.usecase.event.GetAllEventsUseCase
import com.test.domain.usecase.event.GetEventUseCase
import com.test.domain.usecase.event.GetLastEventsUseCase
import com.test.domain.usecase.job.GetAllJobsUseCase
import com.test.domain.usecase.job.GetJobUseCase
import org.koin.dsl.module

val domainDi = module {
    factory {
        GetEventUseCase(
            eventRepository = get()
        )
    }

    factory {
        GetAllEventsUseCase(
            eventRepository = get()
        )
    }

    factory {
        GetLastEventsUseCase(
            eventRepository = get()
        )
    }

    factory {
        GetJobUseCase(
            jobRepository = get()
        )
    }

    factory {
        GetAllJobsUseCase(
            jobRepository = get()
        )
    }
}