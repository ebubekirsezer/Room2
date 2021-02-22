package com.example.room2.basket

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BasketViewModelProviderFactory(val basketRepository: BasketRepository
) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BasketViewModel(basketRepository) as T
    }
}