package com.example.propertymanagement.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.propertymanagement.R
import com.example.propertymanagement.data.model.UserInfo
import com.example.propertymanagement.data.network.MyApi
import com.example.propertymanagement.data.repositories.LoginRepository
import com.example.propertymanagement.database.MyDatabase
import com.example.propertymanagement.databinding.ActivityRegisterBinding
import com.example.propertymanagement.factory.LoginFactory



class RegisterActivity : AppCompatActivity(), LoginListner {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //retrofit
        val myApi = MyApi()
        //room
        val db = MyDatabase(this)
        //connecting room and retrofit to the repo
        val loginRepository = LoginRepository(myApi, db)

        // binds the layout to viewModel
        val registerBinding: ActivityRegisterBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_register)
        val loginFactory = LoginFactory(loginRepository)
        val registerViewModel =
            ViewModelProvider(this, loginFactory).get(LoginViewModel::class.java)

        registerBinding.registerViewModel = registerViewModel

        registerViewModel.loginListner = this


    }

    override fun onStarted() {
        Toast.makeText(applicationContext, "Register Started ", Toast.LENGTH_SHORT).show()
    }

    override fun onSuccess(userInfo: UserInfo) {
        Toast.makeText(applicationContext, "$userInfo is logged in", Toast.LENGTH_LONG)
            .show()
       // startActivity(Intent(this, LoginActivity::class.java))
    }

    override fun onFailure(message: String) {
        Toast.makeText(applicationContext, "" + { message }, Toast.LENGTH_SHORT).show()
    }
}