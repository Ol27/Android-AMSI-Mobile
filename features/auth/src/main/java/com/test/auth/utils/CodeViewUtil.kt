package com.test.auth.utils

import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import com.test.common.ext.ViewExt.Companion.hideKeyboard

// TODO: migrate to separate custom view
class CodeViewUtil {

    private val codeViews = mutableListOf<EditText>()
    fun setUpWithEditText(
        vararg editTexts: EditText,
    ) {
        codeViews.addAll(editTexts)
        editTexts.forEachIndexed { index, editText ->
            editText.setOnKeyListener { _, keyCode, _ ->
                val isDel = keyCode == android.view.KeyEvent.KEYCODE_DEL
                val isEnter = keyCode == android.view.KeyEvent.KEYCODE_ENTER

                if (isDel) {
                    if (editText.text.isEmpty() && index != 0) codeViews[index - 1].requestFocus()
                } else if (isEnter) {
                    editText.clearFocus()
                    if (index != codeViews.lastIndex) codeViews[index + 1].requestFocus()
                }

                false
            }
            editText.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus) editText.setText("")
            }
            editText.doAfterTextChanged {
                val isNotLast = it?.length == 1 && index != codeViews.lastIndex
                val isLast = it?.length == 1 && index == codeViews.lastIndex

                if (isNotLast) codeViews[index + 1].requestFocus()

                if (isLast) {
                    editText.clearFocus()
                    editText.hideKeyboard()
                }
            }
        }
    }

    fun clear() {
        codeViews.clear()
    }

}