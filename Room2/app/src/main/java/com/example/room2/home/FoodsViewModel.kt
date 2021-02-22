package com.example.room2.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class FoodsViewModel(
    val foodsRepository: FoodsRepository
): ViewModel() {

    val foods: MutableLiveData<Resource<FoodsResponse>> = MutableLiveData()

    init {
        getFoods()
    }
    fun getFoods() = viewModelScope.launch{
        foods.postValue(Resource.Loading())
        val response =foodsRepository.getFoods()
        Log.e("Response","Response 1: ${response.body()}")
        foods.postValue(handleFoodsResponse(response))
    }
    private fun handleFoodsResponse(response:Response<FoodsResponse>): Resource<FoodsResponse> {
        if(response.isSuccessful){
            Log.e("Response","Response body:${response.body()}")
            response.body()?.let{ resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}