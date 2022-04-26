package com.example.cocktailusingrepositrycoroutines


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class MainRepository
@Inject
  constructor(private val apiHelper: ApiHelper) {

     fun getList(): Flow<DrinksDataModel> = flow {
        emit(apiHelper.getList())
    }.flowOn(Dispatchers.IO)
}