package com.example.kotlin_retro

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET(".")
    suspend fun getQuotes(
        @Query("apikey") apikey: String,
        @Query("s") s: String,
        @Query("page") page: Int
    ): Response<Movies>
}