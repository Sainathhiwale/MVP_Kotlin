package com.examen.mvpkotlin.data.model


import com.google.gson.annotations.SerializedName

class UserListInfo : ArrayList<UserListInfo.UserListInfoItem>(){
    data class UserListInfoItem(
        @SerializedName("ID")
        val iD: Int,
        @SerializedName("Password")
        val password: String,
        @SerializedName("UserName")
        val userName: String
    )
}