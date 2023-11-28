package com.test.auth.ui

import android.content.Intent
import android.view.WindowManager
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
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        statusBarInset(imageView5, imageView3)
    }

}