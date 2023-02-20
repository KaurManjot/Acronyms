package com.example.simpleacronyms.data.remote

import com.google.gson.annotations.SerializedName

data class Variation(
    val freq: Int,
    @SerializedName("lf")
    val longForm: String,
    val since: Int
)