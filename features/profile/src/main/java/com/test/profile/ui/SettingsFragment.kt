package com.test.profile.ui

import androidx.navigation.fragment.findNavController
import com.test.common.base.BaseFragment
import com.test.navigation.NavExt.Companion.logOut
import com.test.profile.databinding.FragmentSettingsBinding

class SettingsFragment : BaseFragment<FragmentSettingsBinding>(FragmentSettingsBinding::inflate) {
    override fun initView() {
        initListeners()
        statusBarInset(binding.root)
    }

    private fun initListeners() = with(binding) {
        btnSettingsBack.setOnClickListener {
            findNavController().popBackStack()
        }
        btnSettingsLogOut.setOnClickListener {
            requireContext().logOut()
        }
        btnSettingsDeleteAccount.setOnClickListener {
            requireContext().logOut()
        }
    }
}