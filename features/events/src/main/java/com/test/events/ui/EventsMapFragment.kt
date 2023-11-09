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
        viewModel.getEvent(1)
        viewModel.getAllEvents()
        setupBottomSheet()
        setupAdapter()
        binding.btnEventsMapBack.setOnClickListener {
            findNavController().popBackStack()
        }
        val mapFragment =
            childFragmentManager.findFragmentById(R.id.map_events_map_fragment) as? SupportMapFragment
        mapFragment?.getMapAsync { googleMap ->
            setupMap(googleMap)
            addMarkers(googleMap)
        }
    }

    private fun setupMap(googleMap: GoogleMap) {
        googleMap.setOnMarkerClickListener(this)
        googleMap.uiSettings.isCompassEnabled = false
        viewModel.event.observe(viewLifecycleOwner) {
            val cameraUpdate =
                CameraUpdateFactory.newLatLngZoom(getLatLngFromData(it), 15.0f)
            googleMap.moveCamera(cameraUpdate)
        }
    }

    private fun addMarkers(googleMap: GoogleMap) {
        viewModel.eventsList.observe(viewLifecycleOwner) {
            for (i in 0..3) {
                val marker = googleMap.addMarker(
                    MarkerOptions()
                        .position(getLatLngFromData(it[i]))
                        .icon(MapUtil.createCustomMarkerIcon(requireContext()))
                )
                marker.tag = it[i]
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