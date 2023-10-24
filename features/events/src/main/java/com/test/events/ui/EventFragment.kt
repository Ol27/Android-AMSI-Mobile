package com.test.events.ui

import android.content.Intent
import androidx.navigation.fragment.findNavController
import com.test.common.base.BaseFragment
import com.test.common.ext.StringExt.Companion.toDate
import com.test.common.ext.ViewExt.Companion.copyToClipboard
import com.test.events.databinding.FragmentEventBinding
import com.test.events.model.Event


class EventFragment : BaseFragment<FragmentEventBinding>(FragmentEventBinding::inflate) {
    private var event: Event? = null
    override fun initView() {
        event = requireArguments().getParcelable(ARG_EVENT)
        event?.let { setupData(it) }
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.btnCopyToClipboard.setOnClickListener {
            binding.materialTextViewAddress.copyToClipboard("Address")
        }
        binding.btnAddToCalendar.setOnClickListener {
            event?.let { addEventToCalendar(it) }
        }
    }

    private fun setupData(event: Event) = with(binding) {
        materialTextViewEventTitle.text = event.name
        materialTextViewDate.text = event.weekDay
        materialTextViewDay.text = event.dayDate
        materialTextViewTime.text = event.time + " - " + event.endTime
        materialTextViewAddress.text = event.address
        materialTextViewContactInfo.text = event.phone
        materialTextAboutEvent.text = event.aboutInto
    }

    private fun addEventToCalendar(event: Event) {
        val intent = Intent(Intent.ACTION_EDIT)
        intent.type = "vnd.android.cursor.item/event"
        intent.putExtra("title", event.name)
        intent.putExtra("description", event.aboutInto)
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
        const val ARG_EVENT = "event"
    }
}