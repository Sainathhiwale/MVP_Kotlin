package com.examen.mvpkotlin.data.network

import com.examen.mvpkotlin.data.model.LoginRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterface {

    @Headers( "Content-Type: application/json")
    @POST(EndPoints.LOGIN)
    fun createUser(@Body loginRequest:LoginRequest):Call<LoginRequest>

}