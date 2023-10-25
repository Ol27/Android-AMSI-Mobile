package com.test.events.ui

import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.common.base.BaseFragment
import com.test.events.adapter.EventsAdapter
import com.test.events.databinding.FragmentEventsListBinding
import com.test.events.model.Event
import com.test.events.util.MockDataUtil

class EventsListFragment :
    BaseFragment<FragmentEventsListBinding>(FragmentEventsListBinding::inflate) {
    override fun initView() {
        val eventsAdapter = EventsAdapter { event -> navigateToEventScreen(event) }
        binding.rvEventsList.apply {
            adapter = eventsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        eventsAdapter.submitList(MockDataUtil.getMockData())

        binding.btnEventsListMap.setOnClickListener {
            navigateToEventsMapScreen()
        }
    }

    private fun navigateToEventScreen(event: Event) {
        findNavController().navigate(
            com.test.navigation.R.id.action_eventsListFragment_to_eventFragment,
            bundleOf(EventFragment.ARG_EVENT to event)
        )
    }

    private fun navigateToEventsMapScreen() {
        findNavController().navigate(
            com.test.navigation.R.id.action_eventsListFragment_to_eventsMapFragment,
        )
    }
}