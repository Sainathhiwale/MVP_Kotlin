package com.examen.mvpkotlin.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {



    private val NUM_ITEMS = 3

    override fun getItemCount(): Int {
        return  NUM_ITEMS
    }

    override fun createFragment(position: Int): Fragment {
      return Fragment()
    }


}