package com.example.room2.home

import retrofit2.Response
import retrofit2.http.GET

interface FoodsAPI {

    @GET("yemekler/tum_yemekler.php")
    suspend fun getFoods(): Response<FoodsResponse>

    @GET("yemekler/tum_sepet_yemekler")
    suspend fun getSepettekiler(): Response<FoodsResponse>
}