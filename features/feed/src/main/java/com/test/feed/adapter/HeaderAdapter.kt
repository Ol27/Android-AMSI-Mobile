package com.test.feed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.common.factory.DiffFactory
import com.test.feed.databinding.ItemHeaderBinding
import com.test.feed.model.ItemModel


class HeaderAdapter(private val onProfileClicked: () -> Unit) :
    ListAdapter<ItemModel.Header, HeaderAdapter.Holder>(DiffFactory.DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(ItemHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
        holder.binding.imageView5.setOnClickListener {
            onProfileClicked()
        }
    }

    inner class Holder(
        val binding: ItemHeaderBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ItemModel.Header) = with(binding) {}

    }

}