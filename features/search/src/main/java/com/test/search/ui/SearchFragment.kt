package com.test.search.ui


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
import com.test.common.ext.ViewExt.Companion.showKeyboard
import com.test.domain.model.Job
import com.test.search.databinding.FragmentSearchBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {

    private val viewModel: SearchViewModel by viewModel()

    private var jobsAdapter: JobsAdapter? = null
    private var searchAdapter: AutoCompleteJobsAdapter? = null
    private var jobs: List<Job> = listOf()

    override fun initView() {
        initSearch()
        initJobsList()
        initSearchButton()
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
                binding.actvSearch.requestFocus()
                binding.actvSearch.showKeyboard()
                binding.actvSearch.isCursorVisible = true
            }
        }
    }

    private fun initSearch() = with(binding) {
        searchAdapter = AutoCompleteJobsAdapter(requireContext())
        actvSearch.setAdapter(searchAdapter)
        actvSearch.setDropDownBackgroundResource(com.test.common.R.drawable.shape_dropdown_suggestions_container)
        actvSearch.requestFocus()
        actvSearch.showKeyboard()
        actvSearch.setOnClickListener {
            actvSearch.isCursorVisible = true
        }
        actvSearch.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val enteredText = actvSearch.text.toString()
                searchJobs(enteredText)
                return@setOnKeyListener true
            }
            false
        }
        actvSearch.setOnItemClickListener { parent, _, position, _ ->
            val jobSelected = parent.getItemAtPosition(position)
            searchJobs(jobSelected.toString())
        }
    }

    private fun initJobsList() = with(binding) {
        jobsAdapter = JobsAdapter(
            onJobClicked = { navigateToJobScreen(it) },
            onListEmpty = {
                if (it) {
                    tvSearchNoData.visibility = View.VISIBLE
                    rvSearchJobs.visibility = View.GONE
                } else {
                    tvSearchNoData.visibility = View.GONE
                    rvSearchJobs.visibility = View.VISIBLE
                }
            })
        rvSearchJobs.adapter = jobsAdapter
        rvSearchJobs.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun initSearchButton() = with(binding) {
        btnSearch.setOnClickListener {
            val searchText = actvSearch.text.toString()
            searchJobs(searchText)
        }
    }

    private fun searchJobs(text: String) = with(binding) {
        jobsAdapter?.filterJobsByTitle(text)
        actvSearch.text.clear()
        actvSearch.hideKeyboard()
        actvSearch.isCursorVisible = false
        rvSearchJobs.smoothScrollToPosition(0)
    }

    private fun navigateToJobScreen(job: Job) {
        findNavController().navigate(
            com.test.navigation.R.id.action_searchFragment_to_jobFragment,
            bundleOf("ARG_JOB_ID" to job.id)
        )
    }

    override fun clear() {
        super.clear()
        jobsAdapter = null
        searchAdapter = null
    }
}