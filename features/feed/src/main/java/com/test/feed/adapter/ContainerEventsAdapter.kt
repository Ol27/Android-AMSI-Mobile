package com.test.feed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.common.factory.DiffFactory
import com.test.feed.databinding.ItemRecyclerBinding
import com.test.feed.model.ItemModel

class ContainerEventsAdapter :
    ListAdapter<List<ItemModel.Events>, ContainerEventsAdapter.Holder>(DiffFactory.DiffCallback()) {

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

        fun bind(item: List<ItemModel.Events>) = with(binding) {
            rvFeed.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = EventsAdapter().apply { submitList(item) }
            }
        }
    }
}