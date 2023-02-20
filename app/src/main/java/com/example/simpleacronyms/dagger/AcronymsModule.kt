package com.example.simpleacronyms.dagger

import com.example.simpleacronyms.data.remote.AcromineApi
import com.example.simpleacronyms.repository.AcronymsRepository
import com.example.simpleacronyms.repository.AcronymsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AcronymsModule {

    @Provides
    @Singleton
    fun provideAcronymsRepository(api: AcromineApi): AcronymsRepository {
        return AcronymsRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideAcromineApi(): AcromineApi {
        return Retrofit.Builder()
            .baseUrl(AcromineApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AcromineApi::class.java)
    }
}