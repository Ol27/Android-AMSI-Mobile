package com.test.profile.ui.resume

import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import com.test.common.base.BaseFragment
import com.test.common.ext.ViewExt.Companion.requireDate
import com.test.picker.data.Data
import com.test.picker.ui.PickerActivity
import com.test.profile.databinding.FragmentWorkExperienceBinding

class WorkExperienceFragment :
    BaseFragment<FragmentWorkExperienceBinding>(FragmentWorkExperienceBinding::inflate) {
    private val activityResultCountry =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            val pick = it.data?.getStringExtra(PickerActivity.EXTRA_PICK)
            binding.tilWorkCountry.editText!!.setText(pick)
        }

    private val activityResultCompany =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            val pick = it.data?.getStringExtra(PickerActivity.EXTRA_PICK)
            binding.tilWorkCompany.editText!!.setText(pick)
        }

    private val activityResultPosition =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            val pick = it.data?.getStringExtra(PickerActivity.EXTRA_PICK)
            binding.tilWorkPosition.editText!!.setText(pick)
        }

    private val activityResultCity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            val pick = it.data?.getStringExtra(PickerActivity.EXTRA_PICK)
            binding.tilWorkCity.editText!!.setText(pick)
        }

    override fun initView() {
        initPickers()
    }

    private fun initPickers() = with(binding) {
        tilWorkCompany.editText!!.setOnClickListener {
            val intent = generateIntentForPicker(
                ArrayList(Data.Company.asList()),
                "Pick company"
            )
            activityResultCompany.launch(intent)
        }
        tilWorkPosition.editText!!.setOnClickListener {
            val intent = generateIntentForPicker(
                ArrayList(Data.Position.asList()),
                "Pick position"
            )
            activityResultPosition.launch(intent)
        }
        tilWorkCountry.editText!!.setOnClickListener {
            val intent = generateIntentForPicker(
                ArrayList(Data.Country.asList()),
                "Pick country"
            )
            activityResultCountry.launch(intent)
        }
        tilWorkCity.editText!!.setOnClickListener {
            val intent = generateIntentForPicker(
                ArrayList(Data.City.asList()),
                "Pick city"
            )
            activityResultCity.launch(intent)
        }
        tilWorkStart.requireDate(requireContext())
        tilWorkFinish.requireDate(requireContext())
    }

    private fun generateIntentForPicker(array: ArrayList<String>, title: String) =
        Intent(requireContext(), PickerActivity::class.java)
            .putStringArrayListExtra(
                PickerActivity.EXTRA_LIST,
                array
            )
            .putExtra(PickerActivity.EXTRA_TITLE, title)

    companion object {
        fun newInstance() = WorkExperienceFragment()
    }
}