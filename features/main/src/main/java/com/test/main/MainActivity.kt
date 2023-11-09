package com.test.main

import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationBarView
import com.test.common.base.BaseActivity
import com.test.main.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val navController by lazy {
        (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
    }

    private val onNavigationItemSelectedListener = NavigationBarView.OnItemSelectedListener {
        when (it.itemId) {
            R.id.feedFragment -> {
                navController.popBackStack(R.id.feedFragment, true)
                navController.navigate(R.id.feedFragment)
            }

            R.id.eventsListFragment -> {
                navController.popBackStack(R.id.feedFragment, false)
                navController.navigate(R.id.eventsListFragment)
            }

            R.id.jobsListFragment -> {
                navController.popBackStack(R.id.feedFragment, false)
                navController.navigate(R.id.jobsListFragment)
            }
            R.id.profileFragment -> {
                navController.popBackStack(R.id.feedFragment, false)
                navController.navigate(R.id.profileFragment)
            }
        }
        true
    }

    override fun initView() {
        binding.bottomNavigationView.setupWithNavController(navController)
        binding.bottomNavigationView.itemIconTintList = null
        binding.bottomNavigationView.setOnItemSelectedListener(onNavigationItemSelectedListener)
        addDestinationChangeListener()
    }

    private fun addDestinationChangeListener() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                com.test.navigation.R.id.eventFragment,
                com.test.navigation.R.id.eventsMapFragment,
                com.test.navigation.R.id.jobsFilterFragment,
                com.test.navigation.R.id.settingsFragment,
                com.test.navigation.R.id.personalInformationFragment,
                com.test.navigation.R.id.jobApplicationsHistoryFragment,
                com.test.navigation.R.id.resumeFragment,
                com.test.navigation.R.id.editResumeFragment,
                com.test.navigation.R.id.successFragment,
                com.test.navigation.R.id.jobFragment -> binding.navBarView.visibility = View.GONE

                else -> binding.navBarView.visibility = View.VISIBLE
            }
        }
    }
}