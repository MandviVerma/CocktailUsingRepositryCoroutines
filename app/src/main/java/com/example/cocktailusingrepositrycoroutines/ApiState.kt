package com.example.cocktailusingrepositrycoroutines

sealed class ApiState{
    object  Loading: ApiState()
    class Failure(val msg:Throwable): ApiState()
    class Success(val data: List<Drink>): ApiState()
    object Empty: ApiState()


}
