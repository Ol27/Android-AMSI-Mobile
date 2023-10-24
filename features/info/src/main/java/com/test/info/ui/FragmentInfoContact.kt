package com.test.info.ui

import com.test.common.base.BaseFragment
import com.test.info.databinding.FragmentInfoContactBinding

class FragmentInfoContact :
    BaseFragment<FragmentInfoContactBinding>(FragmentInfoContactBinding::inflate) {

    override fun initView() {}

    companion object {
        fun newInstance() = FragmentInfoContact()
    }

}