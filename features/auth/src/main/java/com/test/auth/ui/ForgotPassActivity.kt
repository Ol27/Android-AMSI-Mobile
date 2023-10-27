package com.test.auth.ui

import android.content.Intent
import com.test.auth.databinding.ActivityForgotPassBinding
import com.test.common.base.BaseActivity

class ForgotPassActivity :
    BaseActivity<ActivityForgotPassBinding>(ActivityForgotPassBinding::inflate) {

    override fun initView() {
        initInsetters()
        updateUi()
    }

    private fun updateUi() = with(binding) {
        imageView5.setOnClickListener { finish() }
        btnForgotPassSendEmail.setOnClickListener {
            startActivity(Intent(this@ForgotPassActivity, CodeActivity::class.java))
            finish()
        }
    }

    private fun initInsetters() = with(binding) {
        statusBarInset(imageView5, imageView3)
    }

}