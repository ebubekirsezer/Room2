package com.example.room2.basket

import com.google.gson.annotations.SerializedName

data class BasketResponse(
    @SerializedName("sepet_yemekler")
    val sepet_yemekler: List<SepetYemekler>,
    @SerializedName("success")
    val success: Int
)