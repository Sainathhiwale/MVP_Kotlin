package com.examen.mvpkotlin.data.model

import com.google.gson.annotations.SerializedName

data class LoginRequest (@SerializedName("ID")
                          val iD: Int,
                          @SerializedName("Password")
                          var password: String?=null,
                          @SerializedName("UserName")
                          var userName: String? =null)
