package com.test.events.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.test.common.factory.DiffFactory
import com.test.events.databinding.EventItemBinding
import com.test.events.databinding.FragmentEventBinding
import com.test.events.databinding.FragmentEventsListBinding
import com.test.events.model.Event

class EventsAdapter
    : ListAdapter<Event, EventsAdapter.EventsViewHolder>(DiffFactory.DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsViewHolder
        = EventsViewHolder(EventItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: EventsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class EventsViewHolder(val binding: EventItemBinding) : ViewHolder(binding.root) {
        fun bind(event: Event) = with(binding) {

        }
    }
}