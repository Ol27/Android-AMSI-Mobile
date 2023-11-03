package com.test.events.ui

import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.test.common.base.BaseFragment
import com.test.domain.model.Event
import com.test.events.R
import com.test.events.adapter.EventsAdapter
import com.test.events.databinding.FragmentEventsMapBinding
import com.test.events.util.MapUtil
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventsMapFragment :
    BaseFragment<FragmentEventsMapBinding>(FragmentEventsMapBinding::inflate),
    OnMarkerClickListener {

    private val viewModel: EventsViewModel by viewModel()

    override fun initView() {
        setupBottomSheet()
        setupAdapter()
        binding.btnEventsMapBack.setOnClickListener {
            findNavController().popBackStack()
        }

        val mapFragment =
            childFragmentManager.findFragmentById(R.id.map_events_map_fragment) as? SupportMapFragment

        mapFragment?.getMapAsync { googleMap ->
            googleMap.setOnMarkerClickListener(this)
            googleMap.uiSettings.isCompassEnabled = false
            viewModel.getEvent(1)
            var eventToCenterCamera: Event? = null
            viewModel.event.observe(viewLifecycleOwner) {
                eventToCenterCamera = it
            }
            val cameraUpdate = CameraUpdateFactory.newLatLngZoom(getLatLngFromData(eventToCenterCamera!!), 15.0f)
            googleMap.moveCamera(cameraUpdate)
            addMarkers(googleMap)
        }
    }

    private fun addMarkers(googleMap: GoogleMap) {
        for (i in 0..4) {
            viewModel.getEvent(i.toLong() + 1)
            viewModel.event.observe(viewLifecycleOwner) {
                val event = it
                val marker = googleMap.addMarker(
                    MarkerOptions()
                        .position(getLatLngFromData(event))
                        .icon(MapUtil.createCustomMarkerIcon(requireContext()))
                )
                marker.tag = event
            }
        }
    }

    private fun getLatLngFromData(event: Event): LatLng {
        return LatLng(
            event.lat,
            event.lng
        )
    }

    private fun setupBottomSheet() {
        BottomSheetBehavior.from(binding.eventsMapBottomSheet).apply {
            this.state = BottomSheetBehavior.STATE_COLLAPSED
        }
    }

    private fun setupAdapter() {
        viewModel.getAllEvents()
        val eventsAdapter = EventsAdapter { event -> navigateToEventScreen(event) }
        binding.rvEventsMapList.apply {
            adapter = eventsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        viewModel.eventsList.observe(viewLifecycleOwner) {
            eventsAdapter.submitList(
                mutableListOf(
                    it[0],
                    it[1]
                )
            )
        }
    }

    override fun onMarkerClick(marker: Marker?): Boolean {
        val event = marker?.tag as? Event
        if (event != null) {
            navigateToEventScreen(event)
        }
        return true
    }

    private fun navigateToEventScreen(event: Event) {
        findNavController().navigate(
            com.test.navigation.R.id.action_eventsMapFragment_to_eventFragment,
            bundleOf(EventFragment.ARG_EVENT_ID to event.id)
        )
    }
}