package com.examen.kotlinretrofit.utils

import android.app.Activity
import android.view.WindowManager

object GeneralHelper {

    fun hideStatusbar(activity: Activity){
        activity.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }
}