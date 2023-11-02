package com.test.main

import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.test.common.base.BaseActivity
import com.test.main.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val navController by lazy {
        (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
    }

    override fun initView() {
        binding.bottomNavigationView.setupWithNavController(navController)
        binding.bottomNavigationView.itemIconTintList = null
        addDestinationChangeListener()
    }

    private fun addDestinationChangeListener() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                com.test.navigation.R.id.eventFragment,
                com.test.navigation.R.id.eventsMapFragment,
                com.test.navigation.R.id.jobsFilterFragment,
                com.test.navigation.R.id.jobFragment -> binding.navBarView.visibility = View.GONE
                else -> binding.navBarView.visibility = View.VISIBLE
            }
        }
    }
}