package com.example.room2.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.room2.R
import com.example.room2.basket.BasketDatabase
import com.example.room2.basket.BasketRepository
import com.example.room2.basket.BasketViewModel
import com.example.room2.basket.BasketViewModelProviderFactory

class BasketActivity: AppCompatActivity() {
    lateinit var basketViewModel: BasketViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basket)
        Log.i("Basket", "Start")

        //setupRecyclerView()
        val basketRepository = BasketRepository(BasketDatabase(this))
        val basketViewModelProviderFactory = BasketViewModelProviderFactory(basketRepository)
        basketViewModel =
            ViewModelProvider(this, basketViewModelProviderFactory).get(BasketViewModel::class.java)
    }
}