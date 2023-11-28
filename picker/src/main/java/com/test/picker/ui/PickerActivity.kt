package com.test.picker.ui

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.test.common.base.BaseActivity
import com.test.picker.R
import com.test.picker.adapter.PickerAdapter
import com.test.picker.databinding.ActivityPickerBinding

class PickerActivity : BaseActivity<ActivityPickerBinding>(ActivityPickerBinding::inflate) {

    private val list by lazy { intent.getStringArrayListExtra(EXTRA_LIST) }

    private val title by lazy { intent.getStringExtra(EXTRA_TITLE) }

    private var mAdapter: PickerAdapter? = null

    private var pick: String? = null

    override fun initView() {
        setContentView(binding.root)
        initList()
        initBack()
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        statusBarInset(binding.root)
        navInset(binding.materialButton)
    }

    private fun initBack() {
        binding.imageView5.setOnClickListener { finish() }
    }

    private fun initList() = with(binding) {
        mAdapter = PickerAdapter { p -> pick = p }
        rvList.apply {
            layoutManager = LinearLayoutManager(this@PickerActivity)
            adapter = mAdapter!!.apply {
                submitList(list)
            }
        }
        materialTextView5.text = title
        materialButton.setOnClickListener {
            finishWithResult(pick)
        }
    }

    private fun finishWithResult(pick: String?) {
        pick?.let { setResult(RESULT_OK, intent.putExtra(EXTRA_PICK, pick)) }
        finish()
    }


    companion object {

        const val EXTRA_LIST = "EXTRA_LIST"
        const val EXTRA_TITLE = "EXTRA_TITLE"

        const val EXTRA_PICK = "EXTRA_PICK"

    }

}