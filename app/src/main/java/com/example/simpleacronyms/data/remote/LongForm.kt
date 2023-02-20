package com.example.simpleacronyms.data.remote

import com.google.gson.annotations.SerializedName

data class LongForm(
    val freq: Int,

    @SerializedName("lf")
    val longForm: String,

    val since: Int,

    @SerializedName("vars")
    val variations: List<Variation>
)