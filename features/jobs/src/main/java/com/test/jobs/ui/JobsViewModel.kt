package com.test.jobs.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.domain.model.Job
import com.test.domain.usecase.job.GetAllJobsUseCase
import com.test.domain.usecase.job.GetJobUseCase
import kotlinx.coroutines.launch

class JobsViewModel(
    private val getAllJobsUseCase: GetAllJobsUseCase,
    private val getJobUseCase: GetJobUseCase
) : ViewModel() {
    private val _jobsList: MutableLiveData<List<Job>> = MutableLiveData()
    val jobsList: LiveData<List<Job>> = _jobsList

    private val _job: MutableLiveData<Job> = MutableLiveData()
    val job: LiveData<Job> = _job

    fun getAllJobs() {
        viewModelScope.launch {
            _jobsList.value = getAllJobsUseCase.invoke()
        }
    }

    fun getJob(id: Long) {
        viewModelScope.launch {
            val result = getJobUseCase.invoke(id)
            if (result.isSuccess) {
                _job.value = result.getOrNull()
            }
        }
    }
}