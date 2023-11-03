package com.test.domain.usecase.event

import com.test.domain.model.Event
import com.test.domain.repository.EventRepository

class GetAllEventsUseCase(private val eventRepository: EventRepository) {
    suspend fun invoke(): List<Event> {
        return eventRepository.getAll()
    }
}