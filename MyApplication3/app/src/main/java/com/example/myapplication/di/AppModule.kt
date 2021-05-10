package com.example.myapplication.di

import android.content.Context
import com.example.myapplication.data.network.MyApi
import com.example.myapplication.data.repositories.MainRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


@Module
class AppModule() {

    var BASE_URL = "https://superheroapi.com/api/10218285052986994"

    @Provides
    fun provideRetrofitInstance(): MyApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    fun mainRepository( myApi: MyApi): MainRepository{
        return mainRepository(myApi)
    }
}