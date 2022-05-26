package com.example.tema3.network

import com.example.android.navigation.Clients
import retrofit2.Call
import retrofit2.http.*

interface SpeciesApiService {
    @PUT("/user/signin")
    fun put(@Body body: Clients): Call<Clients>?
}