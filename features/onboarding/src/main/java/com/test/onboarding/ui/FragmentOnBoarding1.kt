package com.test.onboarding.ui

import com.test.common.base.BaseFragment
import com.test.onboarding.databinding.FragmentOnboarding1Binding

class FragmentOnBoarding1 :
    BaseFragment<FragmentOnboarding1Binding>(FragmentOnboarding1Binding::inflate) {
    override fun initView() {}

    companion object {
        fun newInstance() = FragmentOnBoarding1()
    }

}