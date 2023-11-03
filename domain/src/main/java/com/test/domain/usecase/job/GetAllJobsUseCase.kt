package com.test.domain.usecase.job

import com.test.domain.model.Job
import com.test.domain.repository.JobRepository

class GetAllJobsUseCase(private val jobRepository: JobRepository) {
    suspend fun invoke(): List<Job> {
        return jobRepository.getAll()
    }
}