package com.test.events.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.domain.model.Event
import com.test.domain.usecase.event.GetAllEventsUseCase
import com.test.domain.usecase.event.GetEventUseCase
import kotlinx.coroutines.launch

class EventsViewModel(
    private val getEventUseCase: GetEventUseCase,
    private val getAllEventsUseCase: GetAllEventsUseCase
) : ViewModel() {

    private val _eventsList: MutableLiveData<List<Event>> = MutableLiveData()
    val eventsList: LiveData<List<Event>> = _eventsList

    private val _event: MutableLiveData<Event> = MutableLiveData()
    val event: LiveData<Event> = _event

    fun getAllEvents() {
        viewModelScope.launch {
            _eventsList.value = getAllEventsUseCase.invoke()
        }
    }

    fun getEvent(id: Long) {
        viewModelScope.launch {
            val result = getEventUseCase.invoke(id)
            if (result.isSuccess) {
                _event.value = result.getOrNull()
            }
        }
    }
}