package com.examen.mvpkotlin.ui.users.get_user

import com.examen.mvpkotlin.data.model.GetUserDtlsInfo

class UserContractPresenterImpl : UserContract.UserPresenter,UserContract.UserIntractor.OnUserDtlsFinishedListener{
    var userdtlsView:UserContract.UserView ? = null
    var userDtlsIntractor: UserContract.UserIntractor ? = null

    constructor(userdtlsView: UserContract.UserView?, userDtlsIntractor: UserContract.UserIntractor?) {
        this.userdtlsView = userdtlsView
        this.userDtlsIntractor = userDtlsIntractor
    }


    override fun onDestroy() {
        userdtlsView = null
    }

    override fun validateUserDtslFromServer() {
        if (userdtlsView == null) {
            userDtlsIntractor!!.getUserDtlsInfoData(this)
        }
    }

    override fun onUserDtlsFinished(getuserDtsl: GetUserDtlsInfo?) {
        userdtlsView!!.setUserDtlsInfo(getuserDtsl)
    }

    override fun onUserDtlsFailure(throwable: Throwable) {
        userdtlsView!!.onResponseFailure(throwable)
    }
}