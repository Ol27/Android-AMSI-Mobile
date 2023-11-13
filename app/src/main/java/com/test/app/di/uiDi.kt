package com.test.app.di

import com.test.events.ui.EventsViewModel
import com.test.feed.ui.FeedViewModel
import com.test.jobs.ui.JobsViewModel
import com.test.profile.ui.ProfileViewModel
import com.test.search.ui.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiDi = module {
    viewModel {
        EventsViewModel(
            getAllEventsUseCase = get(),
            getEventUseCase = get()
        )
    }

    viewModel {
        JobsViewModel(
            getAllJobsUseCase = get(),
            getJobUseCase = get()
        )
    }

    viewModel {
        FeedViewModel(
            getLastEventsUseCase = get(),
            getJobsUseCase = get()
        )
    }

    viewModel {
        ProfileViewModel(
            getAllJobsUseCase = get()
        )
    }

    viewModel {
        SearchViewModel(
            getAllJobsUseCase = get()
        )
    }
}