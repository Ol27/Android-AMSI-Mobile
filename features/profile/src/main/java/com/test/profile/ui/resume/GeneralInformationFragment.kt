package com.test.profile.ui.resume

import com.test.common.base.BaseFragment
import com.test.profile.databinding.FragmentGeneralInformationBinding

class GeneralInformationFragment :
    BaseFragment<FragmentGeneralInformationBinding>(FragmentGeneralInformationBinding::inflate) {
    override fun initView() {

    }

    companion object {
        fun newInstance() = GeneralInformationFragment()
    }
}