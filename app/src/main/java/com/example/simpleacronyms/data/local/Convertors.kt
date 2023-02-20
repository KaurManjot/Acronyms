package com.example.simpleacronyms.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.simpleacronyms.data.remote.LongForm
import com.example.simpleacronyms.data.util.JsonParser
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Convertors(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromAcronymsJson(json: String): List<String> {
        return jsonParser.fromJson<ArrayList<String>>(
            json,
            object : TypeToken<ArrayList<LongForm>>() {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toAcronymsJson(longForms: List<String>): String {
        return jsonParser.toJson(
            longForms,
            object : TypeToken<ArrayList<String>>() {}.type
        ) ?: "[]"
    }
}