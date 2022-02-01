package com.example.api_demo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Data(


    var avatar: String,
    var email: String,
    @SerializedName("first_name")
    @Expose
    var first_name: String,
    @SerializedName("id")
    @Expose
    var id: Int,
    @SerializedName("last_name")
    @Expose
    var last_name: String
)