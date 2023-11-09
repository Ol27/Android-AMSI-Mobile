package com.test.profile.ui.resume

import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.test.common.base.BaseFragment
import com.test.navigation.R
import com.test.profile.databinding.FragmentResumeBinding

class ResumeFragment : BaseFragment<FragmentResumeBinding>(FragmentResumeBinding::inflate) {

    private val filePickerLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) {}

    override fun initView() {
        binding.btnResumeEdit.setOnClickListener {
            findNavController().navigate(R.id.action_resumeFragment_to_editResumeFragment)
        }
        binding.btnResumeBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.btnResumeDownload.setOnClickListener {
            filePickerLauncher.launch("*/*")
        }
    }
}