package com.examen.mvpkotlin.ui.users.users_list

import android.content.Context
import cn.pedant.SweetAlert.SweetAlertDialog
import com.examen.mvpkotlin.data.model.UserListInfo
import com.examen.mvpkotlin.data.network.ApiInterface
import com.examen.mvpkotlin.data.network.RetrofitInstance
import com.examen.mvpkotlin.utils.CommonUtils
import retrofit2.Call

class GetUserListIntractorImpl:UserListContract.UserListIntractor {
    var context: Context ? = null
    var sweetAlertDialog: SweetAlertDialog ? = null

    override fun getUserListInfoData(onUserListFinishedListener: UserListContract.UserListIntractor.OnUserListFinishedListener) {
      sweetAlertDialog = CommonUtils().startCustomProgressBarDialog(context,"Loading user details Please wait...")
      var apiInterface: ApiInterface = RetrofitInstance.buildService(ApiInterface::class.java)
      var callUserList: Call<UserListInfo.UserListInfoItem>
    }
}