package com.test.auth.ui

import android.content.Intent
import com.test.auth.databinding.ActivityNewPassBinding
import com.test.common.base.BaseActivity

class NewPassActivity : BaseActivity<ActivityNewPassBinding>(ActivityNewPassBinding::inflate) {

    override fun initView() {
        initInsetters()
        initUi()
    }

    private fun initUi() = with(binding) {
        imageView5.setOnClickListener { finish() }

        materialButton.setOnClickListener {
            startActivity(Intent(this@NewPassActivity, SuccessActivity::class.java))
        }
    }

    private fun initInsetters() = with(binding) {
        statusBarInset(imageView5, imageView3)
        navInset(materialButton)
    }

}