package com.example.room2.home

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities=[Yemekler::class],
    version =1
)

abstract class FoodsDatabase : RoomDatabase(){

    abstract fun getFoodsDao(): FoodDao

    companion object {
        @Volatile
        private var instance: FoodsDatabase?=null
        private val LOCK=Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it }
        }
        private fun createDatabase(context: Context)=
            Room.databaseBuilder(
                context.applicationContext,
                FoodsDatabase::class.java,
                "food_db.db"
            ).build()
        }
}