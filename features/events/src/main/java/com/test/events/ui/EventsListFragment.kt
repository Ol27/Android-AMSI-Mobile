package com.test.events.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.events.adapter.EventsAdapter
import com.test.events.databinding.FragmentEventsListBinding
import com.test.events.model.Event

class EventsListFragment : Fragment() {
    private lateinit var binding: FragmentEventsListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEventsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val eventsAdapter = EventsAdapter()
        binding.rvEventsList.apply {
            adapter = eventsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        eventsAdapter.submitList(getMockData())
    }

    private fun navigateToEventScreen(event: Event) {
        findNavController().navigate(
            com.test.navigation.R.id.action_eventsListFragment_to_eventFragment,
            bundleOf(EventFragment.ARG_EVENT_ID to event.id)
        )
    }

    private fun getMockData(): List<Event> {
        return listOf(
            Event(0,"","","","",""),
            Event(0,"","","","",""),
            Event(0,"","","","",""),
            Event(0,"","","","",""),
            Event(0,"","","","",""),
            Event(0,"","","","",""),
            Event(0,"","","","",""),
            Event(0,"","","","",""),
            Event(0,"","","","",""),
            Event(0,"","","","","")
        )
    }
}