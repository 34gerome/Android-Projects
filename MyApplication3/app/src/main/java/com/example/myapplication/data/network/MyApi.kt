package com.example.myapplication.data.network


import com.example.myapplication.data.model.SearchResult
import com.example.myapplication.data.model.SuperHeroResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


//10218285052986994 access token
interface MyApi {
    @GET("/{id}")
  suspend fun getCharacterById(@Path("id")id: String): Response<SuperHeroResponse>

  @GET("/search/{name}")
  suspend fun getCharacterBySearch(@Path("name")name: String): Response<SearchResult>

}