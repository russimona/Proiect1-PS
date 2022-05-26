package com.example.android.navigation

import retrofit2.Call
import retrofit2.http.GET

interface IProducts {
    @GET("products")
    fun getData(): Call<List<Products>>
}