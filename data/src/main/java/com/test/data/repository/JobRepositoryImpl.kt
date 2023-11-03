package com.test.data.repository

import com.test.data.service.JobMockService
import com.test.domain.model.Job
import com.test.domain.repository.JobRepository

class JobRepositoryImpl(private val jobMockService: JobMockService) : JobRepository {
    override suspend fun get(id: Long): Job? {
        return jobMockService.getJobById(id)
    }

    override suspend fun getAll(): List<Job> {
        return jobMockService.getAllJobs()
    }
}