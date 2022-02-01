package com.example.api_demo

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET

interface ApiInterface {

    @GET("users")
    fun getProfile(): Call<Data>

}