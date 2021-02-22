package com.example.room2.basket

import com.example.room2.home.FoodsDatabase
import com.example.room2.home.RetrofitInstance

class BasketRepository(val db:BasketDatabase){
        suspend fun getBasketFoods()= RetrofitInstance2.api.getBasketFoods()
}