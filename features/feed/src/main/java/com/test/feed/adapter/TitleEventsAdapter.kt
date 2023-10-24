package com.test.feed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.common.factory.DiffFactory
import com.test.feed.databinding.ItemTitleEventsBinding
import com.test.feed.model.ItemModel

class TitleEventsAdapter :
    ListAdapter<ItemModel.TitleEvents, TitleEventsAdapter.Holder>(DiffFactory.DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(
            ItemTitleEventsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class Holder(
        private val binding: ItemTitleEventsBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ItemModel.TitleEvents) = with(binding) {
            tvTitleEvents.text = item.text
        }
    }

}