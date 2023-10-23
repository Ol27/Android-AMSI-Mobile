package com.test.auth.ui

import com.test.auth.databinding.ActivitySuccessBinding
import com.test.common.base.BaseActivity

class SuccessActivity : BaseActivity<ActivitySuccessBinding>(ActivitySuccessBinding::inflate) {

    override fun initView() {
        initInsetters()
    }

    private fun initInsetters() = with(binding) {
        statusBarInset(imageView6)
        navInset(materialButton)
    }

}