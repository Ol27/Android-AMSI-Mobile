package com.test.common.util

import android.text.method.PasswordTransformationMethod
import android.view.View

class CustomPasswordTransformationMethod : PasswordTransformationMethod() {
    override fun getTransformation(source: CharSequence, view: View): CharSequence {
        return PasswordCharSequence(source)
    }

    private inner class PasswordCharSequence(private val mSource: CharSequence) : CharSequence {
        override val length: Int
            get() = mSource.length

        override fun get(index: Int): Char {
            return '●'
        }

        override fun subSequence(startIndex: Int, endIndex: Int): CharSequence {
            return mSource.subSequence(startIndex, endIndex)
        }

        override fun toString(): String {
            return mSource.toString()
        }
    }
}