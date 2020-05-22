package com.examen.mvpkotlin.utils

import android.content.Context
import android.graphics.Color
import cn.pedant.SweetAlert.SweetAlertDialog

class CommonUtils {
  private var pDialog:SweetAlertDialog?= null

    fun startCustomProgressBarDialog(context: Context?, message: String?): SweetAlertDialog? {
        pDialog = SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE)
        pDialog!!.progressHelper.barColor = Color.parseColor("#FF4081")
        pDialog!!.titleText = message
        pDialog!!.setCancelable(false)
        pDialog!!.show()
        return pDialog
    }
}