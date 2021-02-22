package com.example.room2.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FoodsViewModelProviderFactory(
    val foodsRepository: FoodsRepository
    ) :ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FoodsViewModel(foodsRepository) as T
    }

}