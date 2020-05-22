package com.examen.mvpkotlin.ui.login

import com.examen.mvpkotlin.data.model.LoginRequest

class LoginPresenterImpl:LoginContract.LoginPresenter,LoginContract.LoginIntractor.OnLoginFinishedListener {
    public var loginView: LoginContract.LoginView? = null
    private var getLoginInIntractor: LoginContract.LoginIntractor? = null

   constructor(loginView: LoginContract.LoginView? , getLoginInIntractor: LoginContract.LoginIntractor?){
       this.loginView =loginView
       this.getLoginInIntractor =getLoginInIntractor
   }

    constructor(loginView: LoginContract.LoginView?) {
        this.loginView = loginView
    }


    override fun onDestroy() {
      loginView=null
    }

    override fun validateLoginFromServer() {
        if (loginView!=null){
            getLoginInIntractor!!.getLoginInfoData(this)
        }
    }

    override fun onLoginFinished(loginRequest: LoginRequest) {
        loginView!!.setLoginInfoData(loginRequest)
    }

    override fun onLoginFailure(throwable: Throwable) {
        loginView!!.onResponseFailure(throwable)
    }
}