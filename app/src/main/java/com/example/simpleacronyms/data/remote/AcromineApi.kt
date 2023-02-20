package com.example.simpleacronyms.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AcromineApi {
    @GET("/software/acromine/dictionary.py/")
    suspend fun getAcronyms(
        @Query("sf") shortForm: String
    ): Response<List<AcromineResponse>>

    companion object {
        const val BASE_URL = "http://www.nactem.ac.uk"
    }
}