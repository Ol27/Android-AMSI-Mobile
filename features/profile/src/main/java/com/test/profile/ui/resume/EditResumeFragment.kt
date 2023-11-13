package com.test.profile.ui.resume

import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.test.common.base.BaseFragment
import com.test.navigation.R
import com.test.profile.databinding.FragmentEditResumeBinding
import com.test.profile.ui.adapter.ResumeAdapter

class EditResumeFragment :
    BaseFragment<FragmentEditResumeBinding>(FragmentEditResumeBinding::inflate) {

    private var mAdapter: ResumeAdapter? = null

    override fun initView() {
        updateNav(0)
        initViewPager()
        binding.btnResumeEditBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.btnResumeEditNext.setOnClickListener {
            if (binding.vpResumeEdit.currentItem == 3) {
                findNavController().navigate(R.id.action_editResumeFragment_to_successFragment)
            } else {
                binding.vpResumeEdit.currentItem = binding.vpResumeEdit.currentItem + 1
            }
        }
        binding.btnResumeEditPrev.setOnClickListener {
            binding.vpResumeEdit.currentItem = binding.vpResumeEdit.currentItem - 1
        }
    }

    private fun initViewPager() = with(binding.vpResumeEdit) {
        mAdapter = ResumeAdapter(requireActivity()).apply {
            setFragments(
                listOf(
                    GeneralInformationFragment.newInstance(),
                    LanguageFragment.newInstance(),
                    EducationFragment.newInstance(),
                    WorkExperienceFragment.newInstance()
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

    private fun updateNav(position: Int) = with(binding) {
        nav0.alpha = if (position >= 0) 1f else 0.2f
        nav1.alpha = if (position >= 1) 1f else 0.2f
        nav2.alpha = if (position >= 2) 1f else 0.2f
        nav3.alpha = if (position >= 3) 1f else 0.2f

        when (position) {
            0 -> {
                btnResumeEditNext.text = "Next"
                btnResumeEditPrev.visibility = View.GONE
            }

            3 -> {
                btnResumeEditNext.text = "Save"
                btnResumeEditPrev.visibility = View.VISIBLE
            }

            else -> {
                btnResumeEditNext.text = "Next"
                btnResumeEditPrev.visibility = View.VISIBLE
            }
        }
    }

    override fun clear() {
        super.clear()
        mAdapter = null
    }
}