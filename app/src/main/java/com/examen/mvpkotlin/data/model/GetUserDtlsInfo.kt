package com.examen.mvpkotlin.data.model


import com.google.gson.annotations.SerializedName

data class GetUserDtlsInfo(
    @SerializedName("ID")
    val iD: Int,
    @SerializedName("Password")
    val password: String,
    @SerializedName("UserName")
    val userName: String
)