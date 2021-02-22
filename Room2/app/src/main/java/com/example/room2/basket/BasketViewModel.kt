package com.example.room2.basket

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class BasketViewModel(val basketRepository: BasketRepository
): ViewModel() {
    val basket: MutableLiveData<Resource2<BasketResponse>> = MutableLiveData()

    init {
        getBasketFoods()
    }
    fun getBasketFoods() = viewModelScope.launch{
        basket.postValue(Resource2.Loading())
        val response =basketRepository.getBasketFoods()
        Log.e("Response","Response 1: ${response.body()}")
        basket.postValue(handleBasketFoodsResponse(response))
    }
    private fun handleBasketFoodsResponse(response: Response<BasketResponse>): Resource2<BasketResponse> {
        if(response.isSuccessful){
            Log.e("Response","Response body:${response.body()}")
            response.body()?.let{ resultResponse ->
                return Resource2.Success(resultResponse)
            }
        }
        return Resource2.Error(response.message())
    }
}