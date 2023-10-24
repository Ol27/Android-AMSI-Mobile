package com.test.info.ui

import androidx.viewpager2.widget.ViewPager2
import com.test.common.base.BaseActivity
import com.test.info.adapter.InfoAdapter
import com.test.info.databinding.ActivityInfoBinding
import dev.chrisbanes.insetter.applyInsetter

class InfoActivity : BaseActivity<ActivityInfoBinding>(ActivityInfoBinding::inflate) {

    private var mAdapter: InfoAdapter? = null

    override fun initView() = with(binding) {
        updateNav(0)
        initInsetters()
        initViewPager()

        imageView.setOnClickListener {
            binding.viewPager2.currentItem = binding.viewPager2.currentItem + 1
        }
    }

    private fun initViewPager() = with(binding.viewPager2) {
        mAdapter = InfoAdapter(this@InfoActivity).apply {
            setFragments(
                listOf(
                    FragmentInfoPhoto.newInstance(),
                    FragmentInfoContact.newInstance(),
                    FragmentInfoLocation.newInstance()
                )
            )
        }

        registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateNav(position)
            }
        })

        adapter = mAdapter
        isUserInputEnabled = false
    }

    private fun initInsetters() = with(binding) {
        navInset(imageView)
        viewPager2.applyInsetter { type(statusBars = true) { padding() } }
    }

    private fun updateNav(position: Int) = with(binding) {
        nav0.alpha = if (position == 0) 1f else 0.5f
        nav1.alpha = if (position == 1) 1f else 0.5f
        nav2.alpha = if (position == 2) 1f else 0.5f
    }


}