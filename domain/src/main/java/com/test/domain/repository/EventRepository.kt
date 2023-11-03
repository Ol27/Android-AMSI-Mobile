package com.test.domain.repository

import com.test.domain.model.Event

interface EventRepository {
    suspend fun get(id: Long): Event?
    suspend fun getAll(): List<Event>
}