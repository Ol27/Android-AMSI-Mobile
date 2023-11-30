package com.test.events.ui

import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.common.base.BaseFragment
import com.test.domain.model.Event
import com.test.events.adapter.EventsAdapter
import com.test.events.databinding.FragmentEventsListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventsListFragment :
    BaseFragment<FragmentEventsListBinding>(FragmentEventsListBinding::inflate) {

    private val viewModel: EventsViewModel by viewModel()

    override fun initView() {
        viewModel.getAllEvents()
        val eventsAdapter = EventsAdapter { event -> navigateToEventScreen(event) }
        binding.rvEventsList.apply {
            adapter = eventsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        viewModel.eventsList.observe(viewLifecycleOwner) {
            eventsAdapter.submitList(it)
        }

        binding.btnEventsListMap.setOnClickListener {
            navigateToEventsMapScreen()
        }
        statusBarInset(binding.root)
    }

    private fun navigateToEventScreen(event: Event) {
        findNavController().navigate(
            com.test.navigation.R.id.action_eventsListFragment_to_eventFragment,
            bundleOf(EventFragment.ARG_EVENT_ID to event.id)
        )
    }

    private fun navigateToEventsMapScreen() {
        findNavController().navigate(
            com.test.navigation.R.id.action_eventsListFragment_to_eventsMapFragment,
        )
    }
}