package com.example.room2.home

import com.google.gson.annotations.SerializedName

data class FoodsResponse(
    @SerializedName("success")
    val success: Int,
    @SerializedName("yemekler")
    val yemekler: List<Yemekler>
)