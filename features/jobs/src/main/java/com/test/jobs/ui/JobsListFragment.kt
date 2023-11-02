package com.test.jobs.ui

import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.common.base.BaseFragment
import com.test.jobs.adapter.JobsAdapter
import com.test.jobs.databinding.FragmentJobsListBinding
import com.test.jobs.model.Job
import com.test.jobs.util.MockJobsDataUtil

class JobsListFragment : BaseFragment<FragmentJobsListBinding>(FragmentJobsListBinding::inflate) {
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
        jobsAdapter.submitList(MockJobsDataUtil.getMockData())
    }

    private fun navigateToJobScreen(job: Job) {
        findNavController().navigate(
            com.test.navigation.R.id.action_jobsListFragment_to_jobFragment,
            bundleOf(JobFragment.ARG_JOB to job)
        )
    }

    private fun navigateToJobsFilter() {
        findNavController().navigate(com.test.navigation.R.id.action_jobsListFragment_to_jobsFilterFragment)
    }
}