package com.example.simpleacronyms.repository

import com.example.simpleacronyms.data.remote.AcromineApi
import com.example.simpleacronyms.data.remote.AcromineResponse
import retrofit2.Response
import javax.inject.Inject

class AcronymsRepositoryImpl @Inject constructor(
    private val api: AcromineApi
) : AcronymsRepository {
    override suspend fun getAcromineResponse(shortForm: String): Response<List<AcromineResponse>> {
        return api.getAcronyms(shortForm)

        /**
         * TODO: 1
         * Cashing Logid
         * Single source of truth - Data will always come from the database
         * Get the data from the API, insert it to the database
         * and then show it in our UI from the database
         */

    }

}