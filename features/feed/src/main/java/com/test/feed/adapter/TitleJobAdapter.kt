package com.test.feed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.common.factory.DiffFactory
import com.test.feed.databinding.ItemTitleJobsBinding
import com.test.feed.model.ItemModel

class TitleJobAdapter :
    ListAdapter<ItemModel.TitleJob, TitleJobAdapter.Holder>(DiffFactory.DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(ItemTitleJobsBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class Holder(
        private val binding: ItemTitleJobsBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ItemModel.TitleJob) = with(binding) {
            tvTitleJobs.text = item.text
        }
    }

}