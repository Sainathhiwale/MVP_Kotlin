package com.examen.mvpkotlin.ui.users.users_list

import android.content.Context
import cn.pedant.SweetAlert.SweetAlertDialog
import com.examen.mvpkotlin.data.model.UserListInfo
import com.examen.mvpkotlin.data.network.ApiInterface
import com.examen.mvpkotlin.data.network.RetrofitInstance
import com.examen.mvpkotlin.utils.CommonUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetUserListIntractorImpl:UserListContract.UserListIntractor {
    var context: Context ? = null
    var sweetAlertDialog: SweetAlertDialog ? = null

    constructor(context: Context?) {
        this.context = context
    }

    override fun getUserListInfoData(onUserListFinishedListener: UserListContract.UserListIntractor.OnUserListFinishedListener) {
      sweetAlertDialog = CommonUtils().startCustomProgressBarDialog(context,"Loading user details Please wait...")
      val apiInterface: ApiInterface = RetrofitInstance.buildService(ApiInterface::class.java)
        val userlistCall: Call<UserListInfo> = apiInterface.getUserList()
        userlistCall.enqueue(object : Callback<UserListInfo> {
            override fun onFailure(call: Call<UserListInfo>, t: Throwable) {
                sweetAlertDialog!!.dismiss()
                onUserListFinishedListener.onUserListFailure(t)
            }

            override fun onResponse(call: Call<UserListInfo>, response: Response<UserListInfo>) {
                sweetAlertDialog!!.dismiss()
                if (response.isSuccessful){
                    onUserListFinishedListener.onUserListFinished(response.body())
                }
            }

        })
        /*userlistCall?.enqueue(object : Callback<List<UserListInfo?>?> {
            override fun onResponse(call: Call<List<UserListInfo?>?>, response: Response<List<UserListInfo?>?>) {
                sweetAlertDialog!!.dismiss()
                if (response.isSuccessful){
                    onUserListFinishedListener.onUserListFinished(response.body())
                }
            }
            override fun onFailure(call: Call<List<UserListInfo?>?>, t: Throwable) {
                sweetAlertDialog!!.dismiss()
                onUserListFinishedListener.onUserListFailure(t)
            }

        })*/

    }
}


