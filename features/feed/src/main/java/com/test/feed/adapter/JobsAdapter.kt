package com.test.feed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.common.databinding.ItemJobBinding
import com.test.common.factory.DiffFactory
import com.test.domain.model.Job


class JobsAdapter(private val openJob: (job: Job) -> Unit) :
    ListAdapter<Job, JobsAdapter.Holder>(DiffFactory.DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(ItemJobBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val job = getItem(position)
        holder.bind(job)
        holder.binding.root.setOnClickListener {
            openJob(job)
        }
    }

    inner class Holder(
        val binding: ItemJobBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(job: Job) = with(binding) {
            tvJobTitle.text = job.title
            tvJobCompany.text = job.company
            tvJobSalary.text = "£\u200E${job.salary} (hourly)"
            tvJobTime.text = job.term
            tvJobNeedPeople.text = "Need ${job.qtyAvailable} person"
            tvJobDistance.text = "${job.distance} miles"
            tvJobPostedTime.text = "${job.minutesAgo} min ago"
        }
    }
}