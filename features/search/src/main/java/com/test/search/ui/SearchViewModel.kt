package com.test.search.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.domain.model.Job
import com.test.domain.usecase.job.GetAllJobsUseCase
import kotlinx.coroutines.launch

class SearchViewModel(
    private val getAllJobsUseCase: GetAllJobsUseCase
) : ViewModel() {

    private val _jobsList: MutableLiveData<List<Job>> = MutableLiveData()
    val jobsList: LiveData<List<Job>> = _jobsList

    fun getAllJobs() {
        viewModelScope.launch {
            _jobsList.value = getAllJobsUseCase.invoke()
        }
    }
}