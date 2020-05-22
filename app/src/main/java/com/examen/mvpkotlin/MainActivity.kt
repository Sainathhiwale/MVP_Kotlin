package com.examen.mvpkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.examen.mvpkotlin.data.prefs.DataManager
import com.examen.mvpkotlin.data.prefs.SharedPrefsHelper
import com.examen.mvpkotlin.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {
   private var dataManager:DataManager?=null
    private var sharedPrefsHelper:SharedPrefsHelper?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataManager = DataManager().getDataManager()
        dataManager?.setLoggedIn()
        initView()
    }

    fun initView(){
       val homeFragment:HomeFragment = HomeFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out)
        transaction.replace(R.id.main_container,homeFragment)
        transaction.addToBackStack("HomeFragment")
        transaction.commit()
    }
}


