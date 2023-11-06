package com.test.jobs.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.common.databinding.ItemJobBinding
import com.test.common.factory.DiffFactory
import com.test.domain.model.Job

class JobsAdapter(
    private val onJobClicked: (Job) -> Unit
) : ListAdapter<Job, JobsAdapter.JobsViewHolder>(DiffFactory.DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobsViewHolder =
        JobsViewHolder(
            ItemJobBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: JobsViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.binding.root.setOnClickListener {
            onJobClicked(getItem(position))
        }
    }

    inner class JobsViewHolder(val binding: ItemJobBinding) :
        RecyclerView.ViewHolder(binding.root) {
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