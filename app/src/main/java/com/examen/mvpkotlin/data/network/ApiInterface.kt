package com.examen.mvpkotlin.data.network

import com.examen.mvpkotlin.data.model.GetUserDtlsInfo
import com.examen.mvpkotlin.data.model.LoginRequest
import com.examen.mvpkotlin.data.model.UserListInfo
import retrofit2.Call
import retrofit2.http.*


interface ApiInterface {

    @Headers( "Content-Type: application/json")
    @POST(EndPoints.LOGIN)
    fun createUser(@Body loginRequest:LoginRequest):Call<LoginRequest>

    @GET(EndPoints.USERLIST)
    fun getUserList(): Call<UserListInfo>

    @GET(EndPoints.GETUSER)
    fun getUserDtls(@Query("id") id: Int?):Call<GetUserDtlsInfo>

}