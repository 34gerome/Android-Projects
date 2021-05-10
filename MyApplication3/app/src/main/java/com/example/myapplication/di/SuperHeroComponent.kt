package com.example.myapplication.di

import com.example.myapplication.ui.main.view.MainActivity
import dagger.Component

@Component(modules = [AppModule::class])
interface SuperHeroComponent {

    fun inject(mainActivity: MainActivity)
}