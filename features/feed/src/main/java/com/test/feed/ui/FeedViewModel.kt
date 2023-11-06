package com.test.feed.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.domain.model.Event
import com.test.domain.model.Job
import com.test.domain.usecase.event.GetLastEventsUseCase
import com.test.domain.usecase.job.GetAllJobsUseCase
import kotlinx.coroutines.launch

class FeedViewModel(
    private val getLastEventsUseCase: GetLastEventsUseCase,
    private val getJobsUseCase: GetAllJobsUseCase
) : ViewModel() {
    private val _eventsList: MutableLiveData<List<Event>> = MutableLiveData()
    val eventsList: LiveData<List<Event>> = _eventsList

    private val _jobsList: MutableLiveData<List<Job>> = MutableLiveData()
    val jobsList: LiveData<List<Job>> = _jobsList

    fun getLastEvents() {
        viewModelScope.launch {
            _eventsList.value = getLastEventsUseCase.invoke()
        }
    }

    fun getJobs() {
        viewModelScope.launch {
            _jobsList.value = getJobsUseCase.invoke()
        }
    }
}