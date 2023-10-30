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

    companion object {
        private const val K_WIDTH = 0.7
        private const val K_HEIGHT = 1.2
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ContainerEventsAdapter.Holder {
        return Holder(
            ItemRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ).apply {
                root.layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    (parent.measuredWidth * K_WIDTH * K_HEIGHT + 16).toInt()
                )
            }
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
                layoutManager =
                    object : LinearLayoutManager(context, HORIZONTAL, false) {
                        override fun checkLayoutParams(lp: RecyclerView.LayoutParams?): Boolean {
                            lp?.width = (measuredWidth * K_WIDTH).toInt()
                            lp?.height = (measuredWidth * K_WIDTH * K_HEIGHT).toInt()
                            return true
                        }
                    }
                adapter = EventsAdapter().apply { submitList(item) }
            }

        }

    }

}