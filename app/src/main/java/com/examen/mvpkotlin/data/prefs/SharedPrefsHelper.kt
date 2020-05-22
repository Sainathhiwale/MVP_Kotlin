package com.examen.mvpkotlin.data.prefs

import android.content.Context
import android.content.SharedPreferences
import com.examen.mvpkotlin.utils.AppConstants

class SharedPrefsHelper {
    private var mSharedPreferences: SharedPreferences? = null

    companion object {
        const val MY_PREFS = "mvp_kotlin"
        const val USERNAME = "USERNAME"
        const val USEREMAIL = "EMAIL"
        const val IS_LOG_IN = "IS_LOG_IN"
    }

    constructor(context: Context) {
        mSharedPreferences = context.getSharedPreferences(MY_PREFS, Context.MODE_PRIVATE)
    }

    fun clear() {
        mSharedPreferences!!.edit().clear().apply()

    }

    fun getLoggedInMode(loggedIn: Boolean): Boolean {
        return mSharedPreferences!!.getBoolean(IS_LOG_IN, loggedIn)
    }

    fun setLoggedInMode(loggedIn: Boolean) {
        mSharedPreferences!!.edit().putBoolean(IS_LOG_IN, loggedIn).apply()
    }
    fun putUserEmail(emailId: String){
        mSharedPreferences!!.edit().putString(USEREMAIL,emailId).apply()
    }

    fun getUseremail(): String? {
        return mSharedPreferences!!.getString(USEREMAIL, AppConstants.EMPTY)
    }

    fun putUserName(userName:String){
        mSharedPreferences!!.edit().putString(USERNAME,userName).apply()
    }

    fun getUserName(): String? {
        return  mSharedPreferences!!.getString(USERNAME,AppConstants.EMPTY)
    }

}