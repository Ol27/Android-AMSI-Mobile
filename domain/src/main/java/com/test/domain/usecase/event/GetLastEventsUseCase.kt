package com.test.domain.usecase.event

import com.test.domain.model.Event
import com.test.domain.repository.EventRepository

class GetLastEventsUseCase(private val eventRepository: EventRepository) {
    suspend fun invoke(): List<Event> {
        return eventRepository.getLast()
    }
}