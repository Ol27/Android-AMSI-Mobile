package com.test.onboarding.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.test.navigation.NavExt.Companion.openAuth
import com.test.onboarding.R
import com.test.onboarding.adapter.OnBoardingAdapter
import com.test.onboarding.databinding.ActivityOnboardingBinding
import dev.chrisbanes.insetter.applyInsetter

class OnBoardingActivity : AppCompatActivity(R.layout.activity_onboarding) {

    private val binding by lazy { ActivityOnboardingBinding.inflate(layoutInflater) }

    private var mAdapter: OnBoardingAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initInsetters()
        initViewPager2()
        binding.imageView.setOnClickListener {
            nextClick()
        }
        binding.materialTextView.setOnClickListener {
            nextClick()
        }
    }

    private fun initInsetters() = with(binding) {
        materialTextView.applyInsetter {
            type(statusBars = true) {
                padding()
            }
        }

        circularProgressIndicator.applyInsetter {
            type(navigationBars = true) {
                padding()
            }
        }

        imageView.applyInsetter {
            type(navigationBars = true) {
                margin()
            }
        }
    }

    private fun initViewPager2() = with(binding.viewPager2) {
        mAdapter = OnBoardingAdapter(this@OnBoardingActivity).apply {
            setFragments(
                listOf(
                    FragmentOnBoarding0.newInstance(),
                    FragmentOnBoarding1.newInstance(),
                    FragmentOnBoarding2.newInstance()
                )
            )
        }
        adapter = mAdapter

        registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                val maxPosition = adapter?.itemCount ?: 0
                calcProgressAndUpdate(position, maxPosition)
            }
        })

    }

    private fun calcProgressAndUpdate(position: Int, maxPosition: Int) {
        val progress = (position + 1) * 100 / maxPosition
        binding.circularProgressIndicator.setProgressCompat(progress, true)
    }

    private fun nextClick() {
        val position = binding.viewPager2.currentItem
        if (position < mAdapter?.itemCount!!) {
            binding.viewPager2.currentItem = position + 1
        }
        if (position == mAdapter?.itemCount!! - 1) {
            openAuth()
            finish()
        }
    }

}