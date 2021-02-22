package com.example.room2.basket

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BasketDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBasket(sepet: SepetYemekler): Long

    @Query("SELECT * FROM sepet_yemekler")
    fun getAllBasket(): LiveData<List<SepetYemekler>>

    @Delete
    suspend fun deleteAllBasket(sepet: SepetYemekler)
}