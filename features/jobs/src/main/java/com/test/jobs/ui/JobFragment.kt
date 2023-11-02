package com.test.jobs.ui

import JobApplyingFragment
import androidx.navigation.fragment.findNavController
import com.test.common.R
import com.test.common.base.BaseFragment
import com.test.jobs.databinding.FragmentJobBinding
import com.test.jobs.model.Job

class JobFragment : BaseFragment<FragmentJobBinding>(FragmentJobBinding::inflate) {

    private val job: Job by lazy {
        requireArguments().getParcelable(ARG_JOB)!!
    }

    override fun initView() {
        initData()
        binding.btnJobDetailsBack.setOnClickListener { findNavController().popBackStack() }
        binding.btnJobDetailsLike.setOnClickListener { likeJob() }
        binding.btnJobDetailsApply.setOnClickListener { showApproveDialog() }
    }

    private fun likeJob() {
        if (job.liked) {
            binding.btnJobDetailsLike.setIconResource(R.drawable.ic_like)
        } else {
            binding.btnJobDetailsLike.setIconResource(R.drawable.ic_like_filled)
        }
        job.liked = !job.liked
    }

    private fun showApproveDialog() {
        val bottomSheetFragment = JobApplyingFragment {
            //applying logic
        }
        bottomSheetFragment.show(childFragmentManager, bottomSheetFragment.tag)
    }

    private fun initData() = with(binding) {
        tvJobDetailsTitle.text = job.title
        tvJobDetailsSpecialty.text = job.speciality
        tvJobDetailsVacancyType.text = job.type
        tvJobDetailsTerm.text = job.term
        tvJobDetailsHolidayDays.text = job.holidayDays.toString()
        tvJobDetailsBenefits.text = job.benefits
        tvJobDetailsWorkingProcess.text = job.workingProcess
        tvJobDetailsQtyAvailable.text = job.qtyAvailable.toString()
        tvJobDetailsDatePublished.text = job.datePublished
        tvJobDetailsPhoneNumber.text = job.phoneNumber
        tvJobDetailsContactPerson.text = job.contactPerson
        tvJobDetailsContactTerm.text = job.term
        tvJobDetailsLanguageEnglish.text = job.englishLanguage
        tvJobDetailsLanguageFrench.text = job.frenchLanguage
        tvJobDetailsStressResistance.text = job.stressResistance
        tvJobDetailsNote.text = job.note
    }

    companion object {
        const val ARG_JOB = "job"
    }
}