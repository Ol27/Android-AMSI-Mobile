package com.test.feed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.common.factory.DiffFactory
import com.test.domain.model.Event
import com.test.feed.databinding.ItemRecyclerBinding

class ContainerEventsAdapter(private val openEvent: (event: Event) -> Unit) :
    ListAdapter<List<Event>, ContainerEventsAdapter.Holder>(DiffFactory.DiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ContainerEventsAdapter.Holder {
        return Holder(
            ItemRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ContainerEventsAdapter.Holder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class Holder(
        private val binding: ItemRecyclerBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: List<Event>) = with(binding) {
            rvFeed.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = EventsAdapter {
                    openEvent(it)
                }.apply { submitList(item) }
            }
        }
    }
}