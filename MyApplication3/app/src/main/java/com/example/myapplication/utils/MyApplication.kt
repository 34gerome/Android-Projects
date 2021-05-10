package com.example.myapplication.utils

import android.app.Application
import com.example.myapplication.di.AppModule
import com.example.myapplication.di.DaggerSuperHeroComponent
import com.example.myapplication.di.SuperHeroComponent

class MyApplication: Application() {
    lateinit var component: SuperHeroComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerSuperHeroComponent.builder().appModule(AppModule()).build()
    }

}