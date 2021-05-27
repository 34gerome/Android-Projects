package com.example.myapplication.data.network


import com.example.myapplication.data.model.SearchResult
import com.example.myapplication.data.model.SuperHeroResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


//10218285052986994 access token
interface MyApi {
    @GET("{id}")
    suspend fun getCharacterById(@Path("id") id: String): Response<SuperHeroResponse>

    @GET("search/{name}")
    suspend fun getCharacterBySearch(@Path("name") name: String): Response<SearchResult>
/*
    @GET("search/{name}")
    suspend fun getCharBySearch(@Path("name") name: String): Obeservable <SearchResult>*/


   /* companion object {
        operator fun invoke(): MyApi {
            var BASE_URL = "https://superheroapi.com/api/10218285052986994/"

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }*/

}