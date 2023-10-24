package com.test.picker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.common.factory.DiffFactory
import com.test.picker.databinding.ItemPickBinding

class PickerAdapter(
    private val callback: (String) -> Unit,
) : ListAdapter<String, PickerAdapter.PickerViewHolder>(DiffFactory.DiffCallback<String>()) {

    private var selectedPos = RecyclerView.NO_POSITION

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PickerViewHolder =
        PickerViewHolder(
            ItemPickBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: PickerViewHolder, position: Int) {
        holder.bind(getItem(position), callback)
    }

    inner class PickerViewHolder(
        private val binding: ItemPickBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String, callback: (String) -> Unit) = with(binding) {
            tvTitle.text = item
            ivNext.isVisible = selectedPos == absoluteAdapterPosition
            root.setOnClickListener {
                selectedPos = absoluteAdapterPosition
                callback(item)
                notifyDataSetChanged()
            }
        }

    }

}