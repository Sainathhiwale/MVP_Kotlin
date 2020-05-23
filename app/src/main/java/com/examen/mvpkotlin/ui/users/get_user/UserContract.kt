package com.examen.mvpkotlin.ui.users.get_user

import com.examen.mvpkotlin.data.model.GetUserDtlsInfo

interface UserContract {

    interface UserView{
        fun setUserDtlsInfo(getuserDtsl: GetUserDtlsInfo?)
        fun onResponseFailure(throwable: Throwable)
    }

    interface UserPresenter{
        fun onDestroy()
        fun validateUserDtslFromServer()
    }

    interface UserIntractor{
        interface OnUserDtlsFinishedListener{
            fun onUserDtlsFinished(getuserDtsl: GetUserDtlsInfo?)
            fun onUserDtlsFailure(throwable: Throwable)
        }
        fun getUserDtlsInfoData(onUserDtlsFinishedListener: OnUserDtlsFinishedListener)
    }
}