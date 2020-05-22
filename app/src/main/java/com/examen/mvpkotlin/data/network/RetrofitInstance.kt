package com.examen.mvpkotlin.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL ="http://fakerestapi.azurewebsites.net/"

    // create okHttp
    private val okHttp:OkHttpClient.Builder = OkHttpClient.Builder();

    //create retrofit buidler
    private val  builder: Retrofit.Builder = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())
    //create retrofit instance
    private  val retrofit: Retrofit = builder.build()

    fun <T> buildService(serivesType: Class<T>):T{
        return retrofit.create(serivesType)
    }
}