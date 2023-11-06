package com.test.events.ui

import android.content.Intent
import androidx.navigation.fragment.findNavController
import com.test.common.R
import com.test.common.base.BaseFragment
import com.test.common.ext.StringExt.Companion.toDate
import com.test.common.ext.ViewExt.Companion.copyToClipboard
import com.test.domain.model.Event
import com.test.events.databinding.FragmentEventBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventFragment : BaseFragment<FragmentEventBinding>(FragmentEventBinding::inflate) {

    private val viewModel: EventsViewModel by viewModel()
    private lateinit var event: Event

    override fun initView() {
        val eventId = requireArguments().getLong(ARG_EVENT_ID)
        viewModel.getEvent(eventId)
        viewModel.event.observe(viewLifecycleOwner) {
            event = it
            setupData(event)
            initListeners()
        }
    }

    private fun initListeners() {
        binding.btnEventBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.btnEventLike.setOnClickListener {
            likeEvent(event)
        }
        binding.btnEventCopyToClipboard.setOnClickListener {
            binding.tvEventAddress.copyToClipboard("Address")
        }
        binding.btnEventAddToCalendar.setOnClickListener {
            addEventToCalendar(event)
        }
    }

    private fun setupData(event: Event) = with(binding) {
        tvEventName.text = event.name
        tvEventWeek.text = event.week
        tvEventDay.text = event.day
        tvEventTime.text = event.startTime + " - " + event.endTime
        tvEventAddress.text = event.address
        tvEventPhone.text = event.phone
        tvEventAbout.text = event.about
    }

    private fun likeEvent(event: Event) {
        if (event.liked) {
            binding.btnEventLike.setIconResource(R.drawable.ic_like)
        } else {
            binding.btnEventLike.setIconResource(R.drawable.ic_like_filled)
        }
        event.liked = !event.liked
    }

    private fun addEventToCalendar(event: Event) {
        val intent = Intent(Intent.ACTION_EDIT)
        intent.type = "vnd.android.cursor.item/event"
        intent.putExtra("title", event.name)
        intent.putExtra("description", event.about)
        val date = event.dateTime.toDate("yyyy-MM-dd HH:mm")
        if (date != null) {
            intent.putExtra("beginTime", date.time)
        }
        intent.putExtra("eventLocation", event.address)
        try {
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    companion object {
        const val ARG_EVENT_ID = "ARG_EVENT_ID"
    }
}