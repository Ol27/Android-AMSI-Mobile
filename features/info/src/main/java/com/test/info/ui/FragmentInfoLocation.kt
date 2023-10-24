package com.test.info.ui

import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import com.test.common.base.BaseFragment
import com.test.info.databinding.FragmentInfoLocationBinding
import com.test.picker.data.Data
import com.test.picker.ui.PickerActivity

class FragmentInfoLocation :
    BaseFragment<FragmentInfoLocationBinding>(FragmentInfoLocationBinding::inflate) {

    private val activityResultCountry =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            val pick = it.data?.getStringExtra(PickerActivity.EXTRA_PICK)
            binding.tilCountry.editText!!.setText(pick)
        }

    private val activityResultCity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            val pick = it.data?.getStringExtra(PickerActivity.EXTRA_PICK)
            binding.tilCity.editText!!.setText(pick)
        }

    override fun initView() = with(binding) {
        tilCity.editText!!.setOnClickListener {
            val intent = generateIntentForPicker(
                ArrayList(Data.City.asList()),
                "Pick your city"
            )
            activityResultCity.launch(intent)
        }
        tilCountry.editText!!.setOnClickListener {
            val intent = generateIntentForPicker(
                ArrayList(Data.Country.asList()),
                "Pick your country"
            )
            activityResultCountry.launch(intent)
        }
    }

    private fun generateIntentForPicker(array: ArrayList<String>, title: String) =
        Intent(requireContext(), PickerActivity::class.java)
            .putStringArrayListExtra(
                PickerActivity.EXTRA_LIST,
                array
            )
            .putExtra(PickerActivity.EXTRA_TITLE, title)

    companion object {
        fun newInstance() = FragmentInfoLocation()
    }

}