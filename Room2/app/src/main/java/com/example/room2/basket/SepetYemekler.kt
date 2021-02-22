package com.example.room2.basket

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(
    tableName="sepet_yemekler"
)
data class SepetYemekler(
    @PrimaryKey(autoGenerate=true)
    val no:Int?=null,
    @SerializedName("yemek_adi")
    val yemek_adi: String,
    @SerializedName("yemek_fiyat")
    val yemek_fiyat: String,
    @SerializedName("yemek_id")
    val yemek_id: String,
    @SerializedName("yemek_resim_adi")
    val yemek_resim_adi: String,
    @SerializedName("yemek_siparis_adet")
    val yemek_siparis_adet: String
)