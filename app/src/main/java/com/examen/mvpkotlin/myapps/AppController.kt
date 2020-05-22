package com.examen.mvpkotlin.myapps

import android.app.Application
import com.examen.mvpkotlin.data.prefs.DataManager
import com.examen.mvpkotlin.data.prefs.SharedPrefsHelper

class AppController : Application() {
    private var dataManager: DataManager? = null
    override fun onCreate() {
        super.onCreate()
        val sharedPrefsHelper = SharedPrefsHelper(applicationContext)
        dataManager = DataManager(sharedPrefsHelper)
    }

    fun getDataManager(): DataManager? {
        return dataManager
    }
}

