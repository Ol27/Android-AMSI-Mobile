package com.test.navigation

import android.content.Context
import android.content.Intent

// todo: migrate from reflection to jetpack navigation
class NavExt {

    companion object {
        fun Context.logOut() {
            val clazz = Class.forName("com.test.auth.ui.AuthActivity")
            val intent = Intent(this, clazz)
            intent.flags =
                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NO_ANIMATION
            startActivity(intent)
        }

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
            val intent = Intent(this, clazz)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}