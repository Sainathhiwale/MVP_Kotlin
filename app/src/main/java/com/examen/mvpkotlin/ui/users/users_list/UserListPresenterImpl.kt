package com.examen.mvpkotlin.ui.users.users_list

import com.examen.mvpkotlin.data.model.UserListInfo

class UserListPresenterImpl : UserListContract.UserListPresenter ,UserListContract.UserListIntractor.OnUserListFinishedListener{
    var userListView:UserListContract.UserListView? =null
    var userlistIntractor:UserListContract.UserListIntractor ? =null

    constructor(
        userListView: UserListContract.UserListView?,
        userlistIntractor: UserListContract.UserListIntractor?
    ) {
        this.userListView = userListView
        this.userlistIntractor = userlistIntractor
    }

    override fun onDestory() {
        userListView = null
    }

    override fun validateUserListFromServer() {
        if (userListView!=null){
            userlistIntractor!!.getUserListInfoData(this)
        }
    }

    override fun onUserListFinished(userListInfoItem: UserListInfo.UserListInfoItem) {
       userListView!!.setUserListInfoData(userListInfoItem)
    }

    override fun onUserListFailure(throwable: Throwable) {
     userListView!!.onResponseFailure(throwable)
    }
}