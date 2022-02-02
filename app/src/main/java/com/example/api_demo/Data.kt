package com.example.api_demo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Data(

    @SerializedName("id"         ) var id        : Int,
    @SerializedName("email"      ) var email     : String,
    @SerializedName("first_name" ) var firstName : String,
    @SerializedName("last_name"  ) var lastName  : String,
    @SerializedName("avatar"     ) var avatar    : String,
)