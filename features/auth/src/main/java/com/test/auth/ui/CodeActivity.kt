package com.test.auth.ui

import android.content.Intent
import android.graphics.Color
import com.test.auth.databinding.ActivityCodeBinding
import com.test.auth.utils.CodeViewUtil
import com.test.common.base.BaseActivity
import com.test.common.ext.ViewExt.Companion.setLinkWithColor

class CodeActivity : BaseActivity<ActivityCodeBinding>(ActivityCodeBinding::inflate) {

    private val codeViewUtil: CodeViewUtil by lazy { CodeViewUtil() }

    override fun initView() {
        initInsetters()
        initViews()
    }

    private fun initInsetters() = with(binding) {
        statusBarInset(imageView5, imageView3)
        navInset(btnCodeVerify)
    }

    private fun initViews() = with(binding) {
        imageView5.setOnClickListener { finish() }
        btnCodeVerify.setOnClickListener {
            startActivity(Intent(this@CodeActivity, NewPassActivity::class.java))
            finish()
        }
        materialTextView61.setLinkWithColor(
            "We have to send the verification to your<br>email <b><a href=''>an****@mail.com</a></b>.",
            Color.parseColor("#111827")
        )
        codeViewUtil.setUpWithEditText(et1, et2, et3, et4)
    }

    override fun clear() {
        codeViewUtil.clear()
    }
}