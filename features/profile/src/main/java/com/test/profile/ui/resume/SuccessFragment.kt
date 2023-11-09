package com.test.profile.ui.resume

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.test.common.base.BaseFragment
import com.test.navigation.R
import com.test.profile.databinding.FragmentSuccessBinding


class SuccessFragment : BaseFragment<FragmentSuccessBinding>(FragmentSuccessBinding::inflate) {
    override fun initView() {
        binding.btnSuccessOk.setOnClickListener {
            navigateHome()
        }
        binding.btnResumeSuccessClose.setOnClickListener {
            navigateHome()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            navigateHome()
        }
    }

    private fun navigateHome() {
        findNavController().popBackStack(R.id.feedFragment, true)
        findNavController().navigate(R.id.feedFragment)
    }
}