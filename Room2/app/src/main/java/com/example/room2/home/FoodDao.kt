package com.example.room2.home

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(yemek: Yemekler): Long

    @Query("SELECT * FROM yemekler")
    fun getAllFoods(): LiveData<List<Yemekler>>

    @Delete
    suspend fun deleteAllFoods(yemek: Yemekler)
}