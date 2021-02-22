package com.example.room2.basket

import com.example.room2.home.Resource

sealed class Resource2<T>(
    val data: T? =null,
    val message:String?=null
) {
    class Success<T>(data:T): Resource2<T>(data)
    class Error<T>(message:String,data:T?=null): Resource2<T>(data,message)
    class Loading<T>: Resource2<T>()
}