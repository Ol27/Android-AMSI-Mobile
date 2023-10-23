package com.test.info.ui

import android.net.Uri
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import coil.load
import coil.transform.CircleCropTransformation
import com.test.common.base.BaseFragment
import com.test.info.databinding.FragmentInfoPhotoBinding

class FragmentInfoPhoto :
    BaseFragment<FragmentInfoPhotoBinding>(FragmentInfoPhotoBinding::inflate) {

    private var activityResultRegistry =
        registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            loadImage(uri)
        }

    override fun initView() = with(binding) {
        materialButton.setOnClickListener {
            openPicker()
        }
    }

    private fun loadImage(uri: Uri?) {
        uri?.let {
            binding.imageView9.load(it) {
                crossfade(true)
                transformations(CircleCropTransformation())
            }
        }
    }

    private fun openPicker() {
        activityResultRegistry.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }

    companion object {
        fun newInstance() = FragmentInfoPhoto()
    }

}