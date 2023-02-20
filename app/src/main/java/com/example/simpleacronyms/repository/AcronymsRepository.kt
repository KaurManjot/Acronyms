package com.example.simpleacronyms.repository

import com.example.simpleacronyms.data.remote.AcromineResponse
import retrofit2.Response

interface AcronymsRepository {
    suspend fun getAcromineResponse(shortForm: String): Response<List<AcromineResponse>>
}