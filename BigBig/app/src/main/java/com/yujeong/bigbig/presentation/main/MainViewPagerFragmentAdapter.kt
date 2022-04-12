package com.yujeong.bigbig.presentation.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.yujeong.bigbig.presentation.EmptyFragment
import com.yujeong.bigbig.presentation.home.HomeFragment

class MainViewPagerFragmentAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment =
        when(position){
            0 -> EmptyFragment()
            1 -> HomeFragment()
            2 -> EmptyFragment()
            3 -> EmptyFragment()
            else -> throw IllegalStateException("********MAIN_VP2_Unexpected_position : $position")
        }
}