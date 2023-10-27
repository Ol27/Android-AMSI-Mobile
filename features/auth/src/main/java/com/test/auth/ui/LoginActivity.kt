package com.test.auth.ui

import android.content.Intent
import android.text.method.PasswordTransformationMethod
import android.view.View
import com.test.auth.databinding.ActivityLoginBinding
import com.test.auth.utils.CustomPasswordTransformationMethod
import com.test.common.base.BaseActivity
import com.test.navigation.NavExt.Companion.openMain

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {

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
            finish()
        }
        materialTextView6.setOnClickListener {
            startActivity(Intent(this@LoginActivity, ForgotPassActivity::class.java))
            finish()
        }
        inputLoginPassword.transformationMethod = CustomPasswordTransformationMethod()
    }

    private fun initInsetter() = with(binding) {
        statusBarInset(imageView5, imageView3)
        navInset(materialButton2)
    }

}