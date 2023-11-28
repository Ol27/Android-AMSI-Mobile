package com.test.auth.ui

import android.content.Intent
import android.view.WindowManager
import com.test.auth.databinding.ActivityLoginBinding
import com.test.common.base.BaseActivity
import com.test.common.ext.ViewExt.Companion.setCustomPasswordMask
import com.test.navigation.NavExt.Companion.openMain

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {

    private var showPassword = false

    override fun initView() {
        initInsetter()
        updateUi()
    }

    private fun updateUi() = with(binding) {
        imageView5.setOnClickListener {
            startActivity(Intent(this@LoginActivity, AuthActivity::class.java))
            finish()
        }
        btnLoginSignin.setOnClickListener {
            openMain()
        }
        materialTextView6.setOnClickListener {
            startActivity(Intent(this@LoginActivity, ForgotPassActivity::class.java))
        }
        inputLoginPassword.setCustomPasswordMask(showPassword)
        layoutLoginPasswordInput.setEndIconOnClickListener {
            showPassword = !showPassword
            inputLoginPassword.setCustomPasswordMask(showPassword)
        }
    }

    private fun initInsetter() = with(binding) {
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        statusBarInset(imageView5, imageView3)
        navInset(materialButton2)
    }

}