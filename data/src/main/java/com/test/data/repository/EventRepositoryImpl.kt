package com.test.data.repository

import com.test.data.service.EventMockService
import com.test.domain.model.Event
import com.test.domain.repository.EventRepository

class EventRepositoryImpl(private val eventMockService: EventMockService) : EventRepository {
    override suspend fun get(id: Long): Event? {
        return eventMockService.getEventById(id)
    }

    override suspend fun getLast(): List<Event> {
        return eventMockService.getLastEvents()
    }

    override suspend fun getAll(): List<Event> {
        return eventMockService.getAllEvents()
    }
}