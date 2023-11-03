package com.test.app.di

import com.test.events.ui.EventsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiDi = module {
    viewModel {
        EventsViewModel(
            getAllEventsUseCase = get(),
            getEventUseCase = get()
        )
    }
}