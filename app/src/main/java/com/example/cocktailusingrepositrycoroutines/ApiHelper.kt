package com.example.cocktailusingrepositrycoroutines

import javax.inject.Inject

class ApiHelper @Inject constructor(private val apiService: ApiService) {

    suspend fun getList() = apiService.getList()
}