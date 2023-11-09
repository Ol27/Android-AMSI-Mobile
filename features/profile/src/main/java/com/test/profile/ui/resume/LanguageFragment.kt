package com.test.profile.ui.resume

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import com.test.common.base.BaseFragment
import com.test.picker.data.Data
import com.test.picker.ui.PickerActivity
import com.test.profile.R
import com.test.profile.databinding.FragmentLanguageBinding


class LanguageFragment : BaseFragment<FragmentLanguageBinding>(FragmentLanguageBinding::inflate) {

    private val activityResultLanguage =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            val pick = it.data?.getStringExtra(PickerActivity.EXTRA_PICK)
            binding.tilLanguageName.editText!!.setText(pick)
        }

    private val activityResultLevel =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            val pick = it.data?.getStringExtra(PickerActivity.EXTRA_PICK)
            binding.tilLanguageLevel.editText!!.setText(pick)
        }

    override fun initView() {
        initPickers()
    }

    private fun initPickers() = with(binding) {
        tilLanguageName.editText!!.setOnClickListener {
            val intent = generateIntentForPicker(
                ArrayList(Data.Language.asList()),
                "Pick language"
            )
            activityResultLanguage.launch(intent)
        }
        tilLanguageLevel.editText!!.setOnClickListener {
            val intent = generateIntentForPicker(
                ArrayList(Data.Level.asList()),
                "Pick level"
            )
            activityResultLevel.launch(intent)
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
        fun newInstance() = LanguageFragment()
    }

}