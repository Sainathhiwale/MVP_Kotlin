package com.examen.mvpkotlin.ui.users.users_list

import com.examen.mvpkotlin.data.model.UserListInfo

interface UserListContract {

    interface UserListView{
        fun setUserListInfoData(userListInfoItem: UserListInfo?)
        fun onResponseFailure(throwable: Throwable)
    }

    interface UserListPresenter{
        fun onDestory()
        fun validateUserListFromServer();
    }

    interface UserListIntractor{
        interface OnUserListFinishedListener{
            fun onUserListFinished(userListInfoItem: UserListInfo?)
            fun onUserListFailure(throwable: Throwable)
        }
        fun getUserListInfoData(onUserListFinishedListener: OnUserListFinishedListener)
    }
}