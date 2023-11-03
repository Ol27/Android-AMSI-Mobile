package com.test.domain.repository

import com.test.domain.model.Job

interface JobRepository {
    suspend fun get(id: Long): Job?
    suspend fun getAll(): List<Job>
}