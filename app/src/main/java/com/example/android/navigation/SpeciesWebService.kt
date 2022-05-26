package com.example.tema3.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object SpeciesWebService {
    private var webApiService: SpeciesApiService? = null
    val instance: SpeciesApiService?
        get() {
            if (webApiService == null) {
                val API_URL = "http://192.168.154.96:8080/"
                val retrofit = Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(provideOkHttp())
                    .build()
                webApiService = retrofit.create(SpeciesApiService::class.java)
            }
            return webApiService
        }

    private fun provideOkHttp(): OkHttpClient {
        val httpBuilder = OkHttpClient.Builder()
        httpBuilder.connectTimeout(30, TimeUnit.SECONDS)
        return httpBuilder.build()
    }
}