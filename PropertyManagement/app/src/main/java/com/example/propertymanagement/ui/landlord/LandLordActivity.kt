package com.example.propertymanagement.ui.landlord

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.propertymanagement.R
import com.example.propertymanagement.data.network.MyApi
import com.example.propertymanagement.data.repositories.LandLordRepository
import com.example.propertymanagement.database.MyDatabase

class LandLordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landlord)

        val myApi = MyApi()
        val db = MyDatabase(this)
        val landLordRepository = LandLordRepository(myApi, db)


    }
}