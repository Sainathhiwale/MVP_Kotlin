package com.examen.mvpkotlin.data.network

import com.examen.mvpkotlin.data.model.LoginRequest
import com.examen.mvpkotlin.data.model.UserListInfo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterface {

    @Headers( "Content-Type: application/json")
    @POST(EndPoints.LOGIN)
    fun createUser(@Body loginRequest:LoginRequest):Call<LoginRequest>

    @GET(EndPoints.USERLIST)
    fun getUserList(userListInfo: UserListInfo):Call<UserListInfo.UserListInfoItem>

}