package com.test.auth.ui

import android.content.Intent
import com.test.auth.databinding.ActivityNewPassBinding
import com.test.common.base.BaseActivity
import com.test.common.ext.ViewExt.Companion.setCustomPasswordMask

class NewPassActivity : BaseActivity<ActivityNewPassBinding>(ActivityNewPassBinding::inflate) {

    private var showPassword = false
    private var showConfirmPassword = false

    override fun initView() {
        initInsetters()
        initUi()
    }

    private fun initUi() = with(binding) {
        imageView5.setOnClickListener { finish() }
        btnNewPassCreate.setOnClickListener {
            startActivity(Intent(this@NewPassActivity, SuccessActivity::class.java))
            finish()
        }
        inputNewPass.setCustomPasswordMask(showPassword)
        inputNewPassConfirm.setCustomPasswordMask(showConfirmPassword)
        layoutNewPasswordInput.setEndIconOnClickListener {
            showPassword = !showPassword
            inputNewPass.setCustomPasswordMask(showPassword)
        }
        layoutNewPasswordConfirmInput.setEndIconOnClickListener {
            showConfirmPassword = !showConfirmPassword
            inputNewPassConfirm.setCustomPasswordMask(showConfirmPassword)
        }
    }

    private fun initInsetters() = with(binding) {
        statusBarInset(imageView5, imageView3)
        navInset(btnNewPassCreate)
    }

}