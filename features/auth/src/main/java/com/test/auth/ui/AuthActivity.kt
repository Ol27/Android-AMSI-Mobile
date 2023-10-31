package com.test.auth.ui

import android.content.Intent
import android.graphics.Color
import com.test.auth.databinding.ActivityAuthBinding
import com.test.common.base.BaseActivity
import com.test.common.ext.ViewExt.Companion.setLinkWithColor


class AuthActivity : BaseActivity<ActivityAuthBinding>(ActivityAuthBinding::inflate) {

    override fun initView() {
        initInsetter()
        initOnClick()
        initUi()
    }

    private fun initUi() = with(binding) {
        materialTextView5.setLinkWithColor(
            "Don’t have an account? <b><a href=''>Sign Up</a></b>",
            Color.parseColor("#EB683A")
        )
    }

    private fun initInsetter() = with(binding) {
        statusBarInset(imageView3)
        navInset(materialTextView5)
    }

    private fun initOnClick() = with(binding) {
        btnAuthEmail.setOnClickListener {
            startActivity(Intent(this@AuthActivity, LoginActivity::class.java))
            finish()
        }
        materialTextView5.setOnClickListener {
            startActivity(Intent(this@AuthActivity, CreateActivity::class.java))
            finish()
        }
    }
}