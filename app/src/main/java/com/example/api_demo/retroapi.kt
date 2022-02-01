package com.example.api_demo

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class retroapi {

    var Base="https://reqres.in/api/"

    var gson:Gson= GsonBuilder().setLenient().create()
    lateinit var retro:retrofit2.Retrofit

    fun getData(): retrofit2.Retrofit {

            retro= retrofit2.Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Base)
                .build()

        return retro
    }
}