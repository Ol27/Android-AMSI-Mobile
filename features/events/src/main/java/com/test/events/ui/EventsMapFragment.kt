package com.test.events.ui

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
import com.test.events.R
import com.test.events.adapter.EventsAdapter
import com.test.events.databinding.FragmentEventsMapBinding
import com.test.events.model.Event
import com.test.events.util.MapUtil
import com.test.events.util.MockDataUtil

class EventsMapFragment :
    BaseFragment<FragmentEventsMapBinding>(FragmentEventsMapBinding::inflate),
    OnMarkerClickListener {
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
            val cameraUpdate = CameraUpdateFactory.newLatLngZoom(getLatLngFromMockData(0), 15.0f)
            googleMap.moveCamera(cameraUpdate)
            addMarkers(googleMap)
        }
    }

    private fun addMarkers(googleMap: GoogleMap) {
        for (i in 0..4) {
            val event = MockDataUtil.getMockData()[i]
            val marker = googleMap.addMarker(
                MarkerOptions()
                    .position(getLatLngFromMockData(i))
                    .icon(MapUtil.createCustomMarkerIcon(requireContext()))
            )
            marker.tag = event
        }
    }

    private fun getLatLngFromMockData(itemCount: Int): LatLng {
        return LatLng(
            MockDataUtil.getMockData()[itemCount].lat,
            MockDataUtil.getMockData()[itemCount].lng
        )
    }

    private fun setupBottomSheet() {
        BottomSheetBehavior.from(binding.eventsMapBottomSheet).apply {
            this.state = BottomSheetBehavior.STATE_COLLAPSED
        }
    }

    private fun setupAdapter() {
        val eventsAdapter = EventsAdapter { event -> navigateToEventScreen(event) }
        binding.rvEventsMapList.apply {
            adapter = eventsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        eventsAdapter.submitList(
            mutableListOf(
                MockDataUtil.getMockData()[0],
                MockDataUtil.getMockData()[1]
            )
        )
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
            bundleOf(EventFragment.ARG_EVENT to event)
        )
    }
}