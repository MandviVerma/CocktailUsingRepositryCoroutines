package com.example.cocktailusingrepositrycoroutines

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitBuilder {

    @Provides
    fun providesBaseUrl()="https://www.thecocktaildb.com/"

    @Provides
    @Singleton
    fun providesApuService(url:String): ApiService =
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)




}

