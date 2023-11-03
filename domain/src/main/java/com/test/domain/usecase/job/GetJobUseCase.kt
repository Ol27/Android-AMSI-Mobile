package com.test.domain.usecase.job

import com.test.domain.exception.Exceptions
import com.test.domain.model.Job
import com.test.domain.repository.JobRepository

class GetJobUseCase(private val jobRepository: JobRepository) {
    suspend fun invoke(id: Long): Result<Job> {
        val job = jobRepository.get(id) ?: return Result.failure(Exceptions.NoDataException())
        return Result.success(job)
    }
}