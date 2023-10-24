package com.test.events.ui

import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.common.base.BaseFragment
import com.test.events.adapter.EventsAdapter
import com.test.events.databinding.FragmentEventsListBinding
import com.test.events.model.Event

class EventsListFragment :
    BaseFragment<FragmentEventsListBinding>(FragmentEventsListBinding::inflate) {
    override fun initView() {
        val eventsAdapter = EventsAdapter { event -> navigateToEventScreen(event) }
        binding.rvEventsList.apply {
            adapter = eventsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        eventsAdapter.submitList(getMockData())
    }

    private fun navigateToEventScreen(event: Event) {
        findNavController().navigate(
            com.test.navigation.R.id.action_eventsListFragment_to_eventFragment,
            bundleOf(EventFragment.ARG_EVENT to event)
        )
    }

    private fun getMockData(): List<Event> {
        return listOf(
            Event(
                "1Self improving stories: A Amazing Workshop",
                "California",
                "10:00 PM",
                "23",
                "Oct",
                "",
                "Friday",
                "11:00 PM",
                "Street, 3, California, USA",
                "+1 100 12 467",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer sit amet lacus ac urna imperdiet tristique eu non tellus. Nunc in ipsum quam. Nulla enim elit, molestie volutpat ullam.",
                "2023-10-23 22:00"
            ),
            Event(
                "2Self improving stories: A Amazing Workshop",
                "California",
                "10:00 PM",
                "23",
                "Oct",
                "",
                "Friday",
                "11:00 PM",
                "Street, 3, California, USA",
                "+1 100 12 467",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer sit amet lacus ac urna imperdiet tristique eu non tellus. Nunc in ipsum quam. Nulla enim elit, molestie volutpat ullam.",
                "2023-10-23 22:00"
            ),
            Event(
                "3Self improving stories: A Amazing Workshop",
                "California",
                "10:00 PM",
                "23",
                "Oct",
                "",
                "Friday",
                "11:00 PM",
                "Street, 3, California, USA",
                "+1 100 12 467",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer sit amet lacus ac urna imperdiet tristique eu non tellus. Nunc in ipsum quam. Nulla enim elit, molestie volutpat ullam.",
                "2023-10-23 22:00"
            ),
            Event(
                "4Self improving stories: A Amazing Workshop",
                "California",
                "10:00 PM",
                "23",
                "Oct",
                "",
                "Friday",
                "11:00 PM",
                "Street, 3, California, USA",
                "+1 100 12 467",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer sit amet lacus ac urna imperdiet tristique eu non tellus. Nunc in ipsum quam. Nulla enim elit, molestie volutpat ullam.",
                "2023-10-23 22:00"
            ),
            Event(
                "5Self improving stories: A Amazing Workshop",
                "California",
                "10:00 PM",
                "23",
                "Oct",
                "",
                "Friday",
                "11:00 PM",
                "Street, 3, California, USA",
                "+1 100 12 467",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer sit amet lacus ac urna imperdiet tristique eu non tellus. Nunc in ipsum quam. Nulla enim elit, molestie volutpat ullam.",
                "2023-10-23 22:00"
            )
        )
    }
}