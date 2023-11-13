package com.test.profile.ui.resume

import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import com.test.common.base.BaseFragment
import com.test.common.ext.ViewExt.Companion.requireDate
import com.test.picker.data.Data
import com.test.picker.ui.PickerActivity
import com.test.profile.databinding.FragmentEducationBinding

class EducationFragment :
    BaseFragment<FragmentEducationBinding>(FragmentEducationBinding::inflate) {

    private val activityResultCountry =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            val pick = it.data?.getStringExtra(PickerActivity.EXTRA_PICK)
            binding.tilEducationCountry.editText!!.setText(pick)
        }

    private val activityResultState =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            val pick = it.data?.getStringExtra(PickerActivity.EXTRA_PICK)
            binding.tilEducationState.editText!!.setText(pick)
        }

    private val activityResultUniversity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            val pick = it.data?.getStringExtra(PickerActivity.EXTRA_PICK)
            binding.tilEducationUniversity.editText!!.setText(pick)
        }

    private val activityResultSpecialty =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            val pick = it.data?.getStringExtra(PickerActivity.EXTRA_PICK)
            binding.tilEducationSpecialty.editText!!.setText(pick)
        }

    override fun initView() {
        initPickers()
    }


    private fun initPickers() = with(binding) {
        tilEducationCountry.editText!!.setOnClickListener {
            val intent = generateIntentForPicker(
                ArrayList(Data.Country.asList()),
                "Pick country"
            )
            activityResultCountry.launch(intent)
        }
        tilEducationState.editText!!.setOnClickListener {
            val intent = generateIntentForPicker(
                ArrayList(Data.State.asList()),
                "Pick state"
            )
            activityResultState.launch(intent)
        }
        tilEducationUniversity.editText!!.setOnClickListener {
            val intent = generateIntentForPicker(
                ArrayList(Data.University.asList()),
                "Pick university"
            )
            activityResultUniversity.launch(intent)
        }
        tilEducationSpecialty.editText!!.setOnClickListener {
            val intent = generateIntentForPicker(
                ArrayList(Data.Specialty.asList()),
                "Pick specialty"
            )
            activityResultSpecialty.launch(intent)
        }
        tilEducationStart.requireDate(requireContext())
        tilEducationFinish.requireDate(requireContext())
    }

    private fun generateIntentForPicker(array: ArrayList<String>, title: String) =
        Intent(requireContext(), PickerActivity::class.java)
            .putStringArrayListExtra(
                PickerActivity.EXTRA_LIST,
                array
            )
            .putExtra(PickerActivity.EXTRA_TITLE, title)

    companion object {
        fun newInstance() = EducationFragment()
    }
}