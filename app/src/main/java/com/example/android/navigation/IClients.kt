package com.example.android.navigation

import retrofit2.Call
import retrofit2.http.GET

interface IClients {
    @GET("users")
    fun getData(): Call<List<Clients>>
}