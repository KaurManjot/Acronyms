package com.example.simpleacronyms.data.util

import androidx.room.ProvidedTypeConverter
import com.google.gson.Gson
import java.lang.reflect.Type

@ProvidedTypeConverter
class GsonParser(
    private val gson: Gson
) : JsonParser {
    override fun <T> fromJson(json: String, type: Type): T? {
        return gson.fromJson(json, type)
    }

    override fun <T> toJson(obj: T, type: Type): String? {
        return gson.toJson(obj, type)
    }
}