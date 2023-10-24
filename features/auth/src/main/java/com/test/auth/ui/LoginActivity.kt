package com.test.auth.ui

import android.content.Intent
import com.test.auth.databinding.ActivityLoginBinding
import com.test.common.base.BaseActivity
import com.test.navigation.NavExt.Companion.openMain

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {

    override fun initView() {
        initInsetter()
        updateUi()
    }

    private fun updateUi() = with(binding) {
        imageView5.setOnClickListener { finish() }
        materialButton.setOnClickListener {
            openMain()
            finish()
        }
        materialTextView6.setOnClickListener {
            startActivity(Intent(this@LoginActivity, ForgotPassActivity::class.java))
        }
    }

    private fun initInsetter() = with(binding) {
        statusBarInset(imageView5, imageView3)
        navInset(materialButton2)
    }

}