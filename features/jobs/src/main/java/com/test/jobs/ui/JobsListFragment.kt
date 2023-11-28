package com.test.jobs.ui

import android.view.KeyEvent
import android.view.View
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.common.adapter.AutoCompleteJobsAdapter
import com.test.common.adapter.JobsAdapter
import com.test.common.base.BaseFragment
import com.test.common.ext.ViewExt.Companion.hideKeyboard
import com.test.domain.model.Job
import com.test.jobs.databinding.FragmentJobsListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class JobsListFragment : BaseFragment<FragmentJobsListBinding>(FragmentJobsListBinding::inflate) {

    private var jobsAdapter: JobsAdapter? = null
    private var searchAdapter: AutoCompleteJobsAdapter? = null
    private var jobs: List<Job> = listOf()
    private val viewModel: JobsViewModel by viewModel()

    override fun initView() {
        initSearch()
        initJobsList()
        initFilter()
        viewModel.getAllJobs()
        viewModel.jobsList.observe(viewLifecycleOwner) {
            jobs = it
            jobsAdapter?.submitJobs(jobs)
            searchAdapter?.submitList(jobs)
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            if (jobsAdapter?.currentList == jobs) {
                findNavController().popBackStack()
            } else {
                jobsAdapter?.submitJobs(jobs)
            }
        }
        statusBarInset(binding.root)
    }

    private fun initFilter() = with(binding) {
        btnJobsFilter.setOnClickListener {
            navigateToJobsFilter()
        }
    }

    private fun initSearch() = with(binding) {
        searchAdapter = AutoCompleteJobsAdapter(requireContext())
        actvJobsSearch.setAdapter(searchAdapter)
        actvJobsSearch.requestFocus()
        actvJobsSearch.isCursorVisible = false
        actvJobsSearch.setDropDownBackgroundResource(com.test.common.R.drawable.shape_dropdown_suggestions_container)
        actvJobsSearch.setOnClickListener {
            actvJobsSearch.isCursorVisible = true
        }
        actvJobsSearch.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val enteredText = actvJobsSearch.text.toString()
                searchJobs(enteredText)
                return@setOnKeyListener true
            }
            false
        }
        actvJobsSearch.setOnItemClickListener { parent, _, position, _ ->
            val jobSelected = parent.getItemAtPosition(position)
            searchJobs(jobSelected.toString())
        }
    }

    private fun initJobsList() = with(binding) {
        jobsAdapter = JobsAdapter(
            onJobClicked = { navigateToJobScreen(it) },
            onListEmpty = {
                if (it) {
                    tvJobsNoData.visibility = View.VISIBLE
                    rvJobsList.visibility = View.GONE
                } else {
                    tvJobsNoData.visibility = View.GONE
                    rvJobsList.visibility = View.VISIBLE
                }
            })
        rvJobsList.adapter = jobsAdapter
        rvJobsList.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun searchJobs(text: String) = with(binding) {
        jobsAdapter?.filterJobsByTitle(text)
        actvJobsSearch.text.clear()
        actvJobsSearch.hideKeyboard()
        actvJobsSearch.isCursorVisible = false
        rvJobsList.smoothScrollToPosition(0)
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

    override fun clear() {
        super.clear()
        jobsAdapter = null
        searchAdapter = null
    }
}