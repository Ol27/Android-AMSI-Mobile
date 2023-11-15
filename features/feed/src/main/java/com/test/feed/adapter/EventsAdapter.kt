package com.test.feed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.common.factory.DiffFactory
import com.test.domain.model.Event
import com.test.feed.databinding.ItemFeedEventBinding

class EventsAdapter(private val openEvent: (event: Event) -> Unit) :
    ListAdapter<Event, EventsAdapter.Holder>(DiffFactory.DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(ItemFeedEventBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val event = getItem(position)
        holder.bind(event)
        holder.binding.btnFeedOpenEvent.setOnClickListener {
            openEvent(event)
        }
    }

    inner class Holder(
        val binding: ItemFeedEventBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(event: Event) = with(binding) {
            tvItemEventDay.text = event.day
            tvItemEventMonth.text = event.month
            tvItemEventTitle.text = event.name
            tvTitleEventCity.text = event.city
            tvTitleEventTime.text = event.startTime
        }
    }
}