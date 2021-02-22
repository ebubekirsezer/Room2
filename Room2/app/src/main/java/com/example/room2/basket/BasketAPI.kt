package com.example.room2.basket

import retrofit2.Response
import retrofit2.http.GET

interface BasketAPI {
    @GET("yemekler/tum_sepet_yemekler.php")
    suspend fun getBasketFoods(): Response<BasketResponse>
}