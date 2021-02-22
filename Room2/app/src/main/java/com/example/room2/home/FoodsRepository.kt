package com.example.room2.home

class FoodsRepository(
    val db: FoodsDatabase
) {
    suspend fun getFoods()= RetrofitInstance.api.getFoods()

}