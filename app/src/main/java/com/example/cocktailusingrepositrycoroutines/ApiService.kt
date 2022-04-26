package com.example.cocktailusingrepositrycoroutines

import retrofit2.http.GET

interface  ApiService {
    @GET("api/json/v1/1/search.php?f=a")
   suspend fun getList(): DrinksDataModel
}