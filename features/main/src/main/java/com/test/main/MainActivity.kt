package com.test.main

import android.content.Context
import android.view.View
import android.view.WindowManager
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
        binding.imageView.setImageResource(com.test.common.R.drawable.btn_search)
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
        initBottomNavigation()
        initSearchButton()
        addDestinationChangeListener()
        binding.imageView.setImageResource(com.test.common.R.drawable.btn_search)
        navInset(binding.navBarView, binding.navHostFragment)
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }

    private fun initSearchButton() = with(binding) {
        imageView.setOnClickListener {
            bottomNavigationView.selectedItemId = R.id.searchFragment
            navController.popBackStack(R.id.feedFragment, false)
            navController.navigate(R.id.searchFragment)
            imageView.setImageResource(com.test.common.R.drawable.btn_search_selected)
        }
    }


    private fun initBottomNavigation() = with(binding) {
        bottomNavigationView.itemIconTintList = null
        bottomNavigationView.setupWithNavController(navController)
        bottomNavigationView.setOnItemSelectedListener(onNavigationItemSelectedListener)
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

                com.test.navigation.R.id.feedFragment -> {
                    binding.navBarView.visibility = View.VISIBLE
                    binding.imageView.setImageResource(com.test.common.R.drawable.btn_search)
                }

                else -> binding.navBarView.visibility = View.VISIBLE
            }
        }
    }
}