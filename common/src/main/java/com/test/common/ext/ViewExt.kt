package com.test.common.ext

import android.app.DatePickerDialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.health.connect.datatypes.units.Length
import android.os.Build
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.URLSpan
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.parseAsHtml
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.test.common.util.CustomPasswordTransformationMethod
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class ViewExt {

    companion object {
        fun TextView.removeLinksUnderline() {
            val spannable = SpannableString(text)
            for (u in spannable.getSpans(0, spannable.length, URLSpan::class.java)) {
                spannable.setSpan(object : URLSpan(u.url) {
                    override fun updateDrawState(ds: TextPaint) {
                        super.updateDrawState(ds)
                        ds.isUnderlineText = false
                    }
                }, spannable.getSpanStart(u), spannable.getSpanEnd(u), 0)
            }
            text = spannable
        }

        fun TextView.setLinkWithColor(text: String, color: Int) {
            setLinkTextColor(color)
            movementMethod = LinkMovementMethod()
            setText(text.parseAsHtml())
            removeLinksUnderline()
        }

        fun View.hideKeyboard() {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(windowToken, 0)
        }

        fun View.showKeyboard() {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
        }

        fun TextView.copyToClipboard(label: String) {
            val clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText(label, text)
            clipboardManager.setPrimaryClip(clipData)
            if (Build.VERSION.SDK_INT < 33) {
                Toast.makeText(context, "Address copied to clipboard", Toast.LENGTH_SHORT).show()
            }
        }

        fun TextInputEditText.setCustomPasswordMask(showPassword: Boolean) {
            transformationMethod = if (showPassword) null else CustomPasswordTransformationMethod()
            text?.let { setSelection(it.length) }
        }

        fun TextInputLayout.requireDate(context: Context) {
            editText?.setOnClickListener {
                val myCalendar = Calendar.getInstance()

                val dateListener = DatePickerDialog.OnDateSetListener { _, year, month, day ->
                    myCalendar.set(Calendar.YEAR, year)
                    myCalendar.set(Calendar.MONTH, month)
                    myCalendar.set(Calendar.DAY_OF_MONTH, day)
                    val myFormat = "dd/MM/yyyy"
                    val dateFormat = SimpleDateFormat(myFormat, Locale.ROOT)
                    editText?.setText(dateFormat.format(myCalendar.time))
                }

                DatePickerDialog(
                    context,
                    dateListener,
                    myCalendar.get(Calendar.YEAR),
                    myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)
                ).show()
            }
        }
    }
}