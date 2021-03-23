package com.example.propertymanagement.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

import com.example.propertymanagement.R
import com.example.propertymanagement.data.model.UserInfo
import com.example.propertymanagement.data.network.MyApi
import com.example.propertymanagement.data.repositories.LoginRepository
import com.example.propertymanagement.database.MyDatabase
import com.example.propertymanagement.databinding.ActivityLoginBinding
import com.example.propertymanagement.factory.LoginFactory
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginListner {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_login)

        //retrofit
        val myApi =  MyApi()
        //room
        val db = MyDatabase(this)
        //connecting room and retrofit to the repo
        val loginRepository = LoginRepository(myApi, db)

        // setup binding with activity and layout
       val loginBinding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        //gets the viewmodel class
        //factory allows info to be passed from repo to viewmodel
        val loginFactory = LoginFactory(loginRepository)

        //

        val loginViewModel = ViewModelProvider(this, loginFactory)
            .get(LoginViewModel::class.java)

        // binds the info with the UI
        // using the name specified from the layout xml
        loginBinding.viewModel = loginViewModel

        loginViewModel.loginListner = this

        // once login verified goes to main activity

    }

    override fun onStarted() {
        progress_bar.visibility = View.VISIBLE
      Toast.makeText(applicationContext, "Login Started ", Toast.LENGTH_SHORT).show()
    }

    override fun onSuccess(userInfo: UserInfo) {
        progress_bar.visibility = View.GONE
            Toast.makeText(applicationContext, "${userInfo.name} is logged in", Toast.LENGTH_LONG).show()
        }

    override fun onFailure(message: String) {
        progress_bar.visibility = View.GONE
        Toast.makeText(applicationContext, ""+ {message}, Toast.LENGTH_SHORT).show()    }
}