package com.example.simpleacronyms.data.remote

import com.google.gson.annotations.SerializedName

data class AcromineResponse(
    @SerializedName("sf")
    val shortForms: String,

    @SerializedName("lfs")
    val longForms: List<LongForm>
)