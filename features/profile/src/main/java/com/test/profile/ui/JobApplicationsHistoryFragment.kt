package com.test.profile.ui

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.common.adapter.JobsAdapter
import com.test.common.base.BaseFragment
import com.test.profile.databinding.FragmentJobApplicationsHistoryBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class JobApplicationsHistoryFragment :
    BaseFragment<FragmentJobApplicationsHistoryBinding>(FragmentJobApplicationsHistoryBinding::inflate) {
    private val viewModel: ProfileViewModel by viewModel()
    override fun initView() {
        initList()
        initListeners()
    }

    private fun initListeners() = with(binding) {
        btnJobApplicationsHistoryBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun initList() {
        val jobsAdapter = JobsAdapter {}
        binding.rvJobApplicationsHistory.apply {
            adapter = jobsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        viewModel.getAllJobs()
        viewModel.jobsList.observe(viewLifecycleOwner) {
            jobsAdapter.submitList(it)
        }
    }
}