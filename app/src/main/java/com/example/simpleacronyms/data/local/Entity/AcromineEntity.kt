package com.example.simpleacronyms.data.local.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.simpleacronyms.data.remote.LongForm
import com.google.gson.annotations.SerializedName

@Entity
data class AcromineEntity(
    val shortForm: String,

    val listOfLongForms: List<String>,

    @PrimaryKey
    val id: Int? = null
)