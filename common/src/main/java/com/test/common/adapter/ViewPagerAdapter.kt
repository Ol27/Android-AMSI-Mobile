package com.test.common.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

abstract class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    private val _fragment = mutableListOf<Fragment>()

    fun setFragments(fragments: List<Fragment>) {
        _fragment.clear()
        _fragment.addAll(fragments)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = _fragment.size

    override fun createFragment(position: Int): Fragment = _fragment[position]

}