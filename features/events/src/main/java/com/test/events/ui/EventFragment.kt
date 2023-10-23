package com.test.events.ui

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.test.events.databinding.FragmentEventBinding
import com.test.main.MainActivity
import java.util.Calendar


class EventFragment : Fragment() {
    private lateinit var binding: FragmentEventBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEventBinding.inflate(inflater, container, false)
        val eventId = requireArguments().getLong(ARG_EVENT_ID)
        (activity as MainActivity).getNavigationView().visibility = View.GONE
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.btnCopyToClipboard.setOnClickListener {
            val clipboardManager = context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("Address", binding.materialTextViewAddress.text)
            clipboardManager.setPrimaryClip(clipData)
        }
        binding.btnAddToCalendar.setOnClickListener {
            val intent = Intent(Intent.ACTION_EDIT)
            intent.type = "vnd.android.cursor.item/event"
            intent.putExtra("title", binding.materialTextViewEventTitle.text)
            startActivity(intent)
        }
    }

    companion object {
        const val ARG_EVENT_ID = "event_id"
    }
}