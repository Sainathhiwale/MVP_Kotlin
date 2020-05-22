package com.examen.mvpkotlin.ui.login

import com.examen.mvpkotlin.data.model.LoginRequest

interface LoginContract {

    interface LoginView{
        fun setLoginInfoData(loginRequest: LoginRequest)
        fun onResponseFailure(throwable: Throwable)
    }

    interface LoginPresenter{
        fun onDestroy()
        fun validateLoginFromServer()
    }
    interface LoginIntractor{
        interface OnLoginFinishedListener{
            fun onLoginFinished(loginRequest: LoginRequest)
            fun onLoginFailure(throwable: Throwable)
        }
        fun getLoginInfoData(onLoginFinishedListener: OnLoginFinishedListener)
    }
}