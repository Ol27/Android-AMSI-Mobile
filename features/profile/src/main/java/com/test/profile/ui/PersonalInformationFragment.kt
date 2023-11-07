package com.test.profile.ui

import android.content.Intent
import android.net.Uri
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import coil.load
import coil.transform.CircleCropTransformation
import com.test.common.base.BaseFragment
import com.test.picker.data.Data
import com.test.picker.ui.PickerActivity
import com.test.profile.databinding.FragmentPersonalInformationBinding


class PersonalInformationFragment :
    BaseFragment<FragmentPersonalInformationBinding>(FragmentPersonalInformationBinding::inflate) {

    private val activityResultCountry =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            val pick = it.data?.getStringExtra(PickerActivity.EXTRA_PICK)
            binding.tilProfileInfoCountry.editText!!.setText(pick)
        }

    private val activityResultCity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            val pick = it.data?.getStringExtra(PickerActivity.EXTRA_PICK)
            binding.tilProfileInfoCity.editText!!.setText(pick)
        }

    private var activityResultPhoto =
        registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            loadImage(uri)
        }

    override fun initView() {
        initListeners()
    }

    private fun initListeners() = with(binding) {
        btnProfileInfoBack.setOnClickListener {
            findNavController().popBackStack()
        }
        btnProfileInfoSave.setOnClickListener {
            findNavController().popBackStack()
        }
        ivProfileInfoPhoto.setOnClickListener {
            openPicker()
        }
        tilProfileInfoCity.editText!!.setOnClickListener {
            val intent = generateIntentForPicker(
                ArrayList(Data.City.asList()),
                "Pick your city"
            )
            activityResultCity.launch(intent)
        }
        tilProfileInfoCountry.editText!!.setOnClickListener {
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

    private fun loadImage(uri: Uri?) {
        uri?.let {
            binding.ivProfileInfoPhoto.load(it) {
                crossfade(true)
                transformations(CircleCropTransformation())
            }
        }
    }

    private fun openPicker() {
        activityResultPhoto.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }
}