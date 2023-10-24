package com.test.common.ext

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
    }
}