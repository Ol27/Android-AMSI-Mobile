package com.test.jobs.ui

import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.common.base.BaseFragment
import com.test.domain.model.Job
import com.test.common.adapter.JobsAdapter
import com.test.jobs.databinding.FragmentJobsListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class JobsListFragment : BaseFragment<FragmentJobsListBinding>(FragmentJobsListBinding::inflate) {

    private val viewModel: JobsViewModel by viewModel()

    override fun initView() {
        initJobsList()
        binding.btnJobsFilter.setOnClickListener { navigateToJobsFilter() }
    }

    private fun initJobsList() {
        val jobsAdapter = JobsAdapter { navigateToJobScreen(it) }
        binding.rvJobsList.apply {
            adapter = jobsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        viewModel.getAllJobs()
        viewModel.jobsList.observe(viewLifecycleOwner) {
            jobsAdapter.submitList(it)
        }
    }

    private fun navigateToJobScreen(job: Job) {
        findNavController().navigate(
            com.test.navigation.R.id.action_jobsListFragment_to_jobFragment,
            bundleOf(JobFragment.ARG_JOB_ID to job.id)
        )
    }

    private fun navigateToJobsFilter() {
        findNavController().navigate(com.test.navigation.R.id.action_jobsListFragment_to_jobsFilterFragment)
    }
}