package com.example.myapplication.ui.main.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.data.model.SuperHero
import com.example.myapplication.databinding.ActivitySuperHeroBinding

class SuperHeroActivity : AppCompatActivity() {

     lateinit var heroInfo: SuperHero
    lateinit var binding: ActivitySuperHeroBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_super_hero)

        init()

    }

    private fun init() {

        heroInfo = intent.getParcelableExtra("hero")!!
        binding.heroInfo = heroInfo
    }
}