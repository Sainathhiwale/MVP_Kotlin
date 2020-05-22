package com.examen.mvpkotlin.ui.login

import android.content.Context
import cn.pedant.SweetAlert.SweetAlertDialog
import com.examen.mvpkotlin.data.model.LoginRequest
import com.examen.mvpkotlin.data.network.ApiInterface
import com.examen.mvpkotlin.data.network.RetrofitInstance
import com.examen.mvpkotlin.utils.CommonUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetLoginIntractorImpl:LoginContract.LoginIntractor {
    private var context: Context? = null
    private var username: String? = null
    private  var userPassword:String? = null
    private var sweetAlertDialog: SweetAlertDialog? = null

    constructor(context: Context? ,username: String?, userPassword: String?) {
        this.context =context
        this.username = username
        this.userPassword = userPassword
    }


    override fun getLoginInfoData(onLoginFinishedListener: LoginContract.LoginIntractor.OnLoginFinishedListener) {
        sweetAlertDialog = CommonUtils().startCustomProgressBarDialog(context,"Sign In User Please wait...")
        val apiServices: ApiInterface = RetrofitInstance.buildService(ApiInterface::class.java)
        val userCall: Call<LoginRequest> = apiServices.createUser(LoginRequest(1,username,userPassword))
        userCall.enqueue(object : Callback<LoginRequest?> {
            override fun onResponse(call: Call<LoginRequest?>, response: Response<LoginRequest?>) {
                sweetAlertDialog!!.dismiss()
                onLoginFinishedListener.onLoginFinished(response!!.body()!!)
            }

            override fun onFailure(call: Call<LoginRequest?>, t: Throwable) {
                sweetAlertDialog!!.dismiss()
                onLoginFinishedListener.onLoginFailure(t)
            }
        })
    }
}