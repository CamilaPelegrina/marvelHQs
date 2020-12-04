package com.example.marvelhqs.service


import com.example.marvelhqs.domain.Entities
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface Repository{

    @GET("comics")
    suspend fun getComics(
        @Query("offset")
        offset: Int,
        @Query("limit")
        limit: Int,
        @Query("ts")
        ts: Int,
        @Query("apikey")
        apikey: String,
        @Query("hash")
        hash: String
    ): Entities
}

val urlApiMarvel = "https://gateway.marvel.com/v1/public/"

val retrofit = Retrofit.Builder()
        .baseUrl(urlApiMarvel)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

val repository: Repository = retrofit.create(Repository::class.java)