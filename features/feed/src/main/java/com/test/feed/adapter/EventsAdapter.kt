package com.test.feed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.common.factory.DiffFactory
import com.test.feed.databinding.ItemEventBinding
import com.test.feed.model.ItemModel

class EventsAdapter :
    ListAdapter<ItemModel.Events, EventsAdapter.Holder>(DiffFactory.DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(ItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class Holder(
        private val binding: ItemEventBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ItemModel.Events) = with(binding) {}

    }

}