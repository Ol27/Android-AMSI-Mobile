package com.test.profile.ui

import androidx.navigation.fragment.findNavController
import com.test.common.base.BaseFragment
import com.test.navigation.R
import com.test.profile.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {
    override fun initView() {
        initListeners()
        statusBarInset(binding.root)
    }

    private fun initListeners() = with(binding) {
        binding.cvProfileMyResume.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_resumeFragment)
        }

        binding.cvProfilePersonalInformation.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_personalInformationFragment)
        }

        binding.cvProfileJobApplicationsHistory.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_jobApplicationsHistoryFragment)
        }

        binding.cvProfileSettings.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_settingsFragment)
        }
    }
}