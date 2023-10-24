package com.test.navigation

import android.content.Context
import android.content.Intent

// todo: migrate from reflection to jetpack navigation
class NavExt {

    companion object {

        fun Context.openAuth() {
            val clazz = Class.forName("com.test.auth.ui.AuthActivity")
            startActivity(Intent(this, clazz))
        }

        fun Context.openInfo() {
            val clazz = Class.forName("com.test.info.ui.InfoActivity")
            startActivity(Intent(this, clazz))
        }

        fun Context.openOnBoarding() {
            val clazz = Class.forName("com.test.onboarding.ui.OnBoardingActivity")
            startActivity(Intent(this, clazz))
        }

        fun Context.openMain() {
            val clazz = Class.forName("com.test.main.MainActivity")
            startActivity(Intent(this, clazz))
        }

    }

}