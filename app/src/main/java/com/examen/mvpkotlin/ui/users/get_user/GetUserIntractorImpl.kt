package com.examen.mvpkotlin.ui.users.get_user

import android.content.Context
import cn.pedant.SweetAlert.SweetAlertDialog
import com.examen.mvpkotlin.data.model.GetUserDtlsInfo
import com.examen.mvpkotlin.data.network.ApiInterface
import com.examen.mvpkotlin.data.network.RetrofitInstance
import com.examen.mvpkotlin.utils.CommonUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetUserIntractorImpl : UserContract.UserIntractor {
    var context:Context ? = null
    var id:Int ? = null
    var sweetAlertDialog:SweetAlertDialog ? = null

    constructor(context: Context?, id: Int?) {
        this.context = context
        this.id = id
    }


    override fun getUserDtlsInfoData(onUserDtlsFinishedListener: UserContract.UserIntractor.OnUserDtlsFinishedListener) {
        sweetAlertDialog = CommonUtils().startCustomProgressBarDialog(context,"User Data is Loading")
       val apiInterface : ApiInterface = RetrofitInstance.buildService(ApiInterface::class.java)
        val getUserCall : Call<GetUserDtlsInfo> = apiInterface.getUserDtls(id)
        getUserCall.enqueue(object : Callback<GetUserDtlsInfo> {
            override fun onFailure(call: Call<GetUserDtlsInfo>, t: Throwable) {
              sweetAlertDialog!!.dismiss()
                onUserDtlsFinishedListener.onUserDtlsFailure(t)
            }

            override fun onResponse(call: Call<GetUserDtlsInfo>, response: Response<GetUserDtlsInfo>) {
                sweetAlertDialog!!.dismiss()
                if (response.isSuccessful){
                    onUserDtlsFinishedListener.onUserDtlsFinished(response.body())
                }
            }

        })
    }
}