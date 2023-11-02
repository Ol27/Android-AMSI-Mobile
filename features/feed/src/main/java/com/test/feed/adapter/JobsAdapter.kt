package com.test.feed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.common.factory.DiffFactory
import com.test.common.databinding.ItemJobBinding
import com.test.feed.model.ItemModel


class JobsAdapter :
    ListAdapter<ItemModel.Job, JobsAdapter.Holder>(DiffFactory.DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(ItemJobBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class Holder(
        private val binding: ItemJobBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ItemModel.Job) = with(binding) {

        }

    }

}