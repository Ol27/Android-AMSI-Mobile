package com.test.common.factory

import androidx.recyclerview.widget.DiffUtil

object DiffFactory {

    open class BaseCallback<T> {
        open fun areItemsTheSame(oldItem: T, newItem: T): Boolean = oldItem == newItem
        open fun areContentsTheSame(oldItem: T, newItem: T): Boolean = oldItem == newItem
    }

    class DiffCallback<T>(
        private val callback: BaseCallback<T> = BaseCallback(),
    ) : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T & Any, newItem: T & Any): Boolean =
            callback.areItemsTheSame(oldItem, newItem)

        override fun areContentsTheSame(oldItem: T & Any, newItem: T & Any): Boolean =
            callback.areContentsTheSame(oldItem, newItem)

    }

}