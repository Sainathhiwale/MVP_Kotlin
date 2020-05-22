package com.examen.mvpkotlin.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.widget.ViewPager2
import com.examen.mvpkotlin.R
import com.examen.mvpkotlin.adapter.ViewPagerAdapter
import com.examen.mvpkotlin.ui.home.HomeFragment
import com.google.android.material.tabs.TabLayout

/**
 * A simple [Fragment] subclass.
 */
class UsersFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View? = inflater.inflate(R.layout.fragment_users, container, false)
        return view
    }



}
