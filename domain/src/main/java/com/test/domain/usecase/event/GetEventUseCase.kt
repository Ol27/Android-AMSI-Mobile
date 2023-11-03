package com.test.domain.usecase.event

import com.test.domain.exception.Exceptions
import com.test.domain.model.Event
import com.test.domain.repository.EventRepository

class GetEventUseCase(private val eventRepository: EventRepository) {
    suspend fun invoke(id: Long): Result<Event> {
        val event = eventRepository.get(id) ?: return Result.failure(Exceptions.NoDataException())
        return Result.success(event)
    }
}