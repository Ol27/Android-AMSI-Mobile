package com.test.jobs.ui

import androidx.navigation.fragment.findNavController
import com.test.common.base.BaseFragment
import com.test.jobs.databinding.FragmentJobsFilterBinding

class JobsFilterFragment :
    BaseFragment<FragmentJobsFilterBinding>(FragmentJobsFilterBinding::inflate) {
    override fun initView() = with(binding) {
        chbFilterExactMatches.buttonTintList = null
        chbFilterMediumMatches.buttonTintList = null
        chbFilterPreScreen.buttonTintList = null

        chbFilterMediumMatches.isChecked = true
        rbFilterHighestPay.isChecked = true

        btnFilterApply.setOnClickListener { findNavController().popBackStack() }
        btnFilterBack.setOnClickListener { findNavController().popBackStack() }
        statusBarInset(binding.root)
    }
}