package com.test.events.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.test.common.factory.DiffFactory
import com.test.events.databinding.EventItemBinding
import com.test.events.model.Event

class EventsAdapter(
    private val onEventClicked: (Event) -> Unit
) : ListAdapter<Event, EventsAdapter.EventsViewHolder>(DiffFactory.DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsViewHolder =
        EventsViewHolder(
            EventItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: EventsViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.binding.cardEvent.setOnClickListener {
            onEventClicked(getItem(position))
        }
    }

    inner class EventsViewHolder(val binding: EventItemBinding) : ViewHolder(binding.root) {
        fun bind(event: Event) = with(binding) {
            tvEventItemName.text = event.name
            tvEventItemMonth.text = event.month
            tvEventItemCity.text = event.city
            tvEventItemStartTime.text = event.startTime
            tvEventItemDay.text = event.day
        }
    }
}