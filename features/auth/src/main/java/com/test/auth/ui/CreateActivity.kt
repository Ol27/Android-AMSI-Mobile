package com.test.auth.ui

import com.test.auth.databinding.ActivityCreateBinding
import com.test.common.base.BaseActivity
import com.test.common.ext.ViewExt.Companion.setCustomPasswordMask
import com.test.navigation.NavExt.Companion.openInfo

class CreateActivity : BaseActivity<ActivityCreateBinding>(ActivityCreateBinding::inflate) {

    private var showPassword = false

    override fun initView() {
        initInsetters()
        initUi()
    }

    private fun initUi() = with(binding) {
        imageView5.setOnClickListener { finish() }
        btnCreateSignup.setOnClickListener {
            openInfo()
            finish()
        }
        inputCreatePassword.setCustomPasswordMask(showPassword)
        layoutCreatePasswordInput.setEndIconOnClickListener {
            showPassword = !showPassword
            inputCreatePassword.setCustomPasswordMask(showPassword)
        }
    }

    private fun initInsetters() = with(binding) {
        statusBarInset(imageView5, imageView3)
        navInset(materialButton2)
    }

}