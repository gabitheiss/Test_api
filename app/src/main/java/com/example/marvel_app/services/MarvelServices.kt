package com.example.marvel_app.services

import com.example.marvel_app.BuildConfig
import dagger.Module
import dagger.Provides
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface MarvelServices {

    @GET("/v1/public/characters")
    suspend fun getAll(
                            @Query("ts") ts : String,
                            @Query("apikey") apikey : String = BuildConfig.API_KEY,
                            @Query("hash") hash : String) : Response<Character>

}