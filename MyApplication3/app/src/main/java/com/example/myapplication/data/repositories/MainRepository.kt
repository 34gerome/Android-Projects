package com.example.myapplication.data.repositories


import com.example.myapplication.data.model.SearchResult
import com.example.myapplication.data.model.SuperHeroResponse
import com.example.myapplication.data.network.ApiRequest
import com.example.myapplication.data.network.MyApi
import retrofit2.Response
import javax.inject.Inject

/*class MainRepository constructor (@Inject val myApi: MyApi): ApiRequest(){

    suspend fun getCharacter(id: String): SuperHeroResponse {
        return apiRequest { myApi.getCharacterById(id) }

    }
    suspend fun getCharacterBySearch(name: String): SearchResult  {
        return apiRequest { myApi.getCharacterBySearch(name) }

    }
}*/


class MainRepository (var myApi: MyApi): ApiRequest(){

    suspend fun getCharacter(id: String): SuperHeroResponse {
        return apiRequest { myApi.getCharacterById(id) }
    }
    suspend fun getCharacterBySearch(name: String): SearchResult  {
        return apiRequest { myApi.getCharacterBySearch(name) }
    }
}