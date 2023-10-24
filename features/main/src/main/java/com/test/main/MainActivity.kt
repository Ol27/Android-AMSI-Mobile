package com.test.main

import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.test.common.base.BaseActivity
import com.test.main.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val navController by lazy {
        (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
    }

    override fun initView() {
        binding.bottomNavigationView.setupWithNavController(navController)
        addDestinationChangeListener()
    }
    private fun addDestinationChangeListener() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == com.test.navigation.R.id.eventFragment) {
                binding.navBarView.visibility = View.GONE
            } else {
                binding.navBarView.visibility = View.VISIBLE
            }
        }
    }
}