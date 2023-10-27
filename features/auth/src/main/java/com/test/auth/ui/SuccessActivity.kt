package com.test.auth.ui

import android.content.Intent
import com.test.auth.databinding.ActivitySuccessBinding
import com.test.common.base.BaseActivity

class SuccessActivity : BaseActivity<ActivitySuccessBinding>(ActivitySuccessBinding::inflate) {

    override fun initView() {
        initInsetters()
        initUi()
    }

    private fun initUi() = with(binding) {
        btnSuccessClose.setOnClickListener {
            startActivity(Intent(this@SuccessActivity, LoginActivity::class.java))
            finish()
        }
        btnSuccessLogin.setOnClickListener {
            startActivity(Intent(this@SuccessActivity, LoginActivity::class.java))
            finish()
        }
    }

    private fun initInsetters() = with(binding) {
        statusBarInset(btnSuccessClose)
        navInset(btnSuccessLogin)
    }
}