package com.test.auth.ui

import com.test.auth.databinding.ActivityCreateBinding
import com.test.common.base.BaseActivity
import com.test.navigation.NavExt.Companion.openInfo

class CreateActivity : BaseActivity<ActivityCreateBinding>(ActivityCreateBinding::inflate) {

    override fun initView() {
        initInsetters()
        initUi()
    }

    private fun initUi() = with(binding) {
        imageView5.setOnClickListener { finish() }
        materialButton.setOnClickListener {
            openInfo()
            finish()
        }
    }

    private fun initInsetters() = with(binding) {
        statusBarInset(imageView5, imageView3)
        navInset(materialButton2)
    }

}