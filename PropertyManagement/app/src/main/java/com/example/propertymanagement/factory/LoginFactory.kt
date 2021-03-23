package com.example.propertymanagement.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.propertymanagement.data.repositories.LoginRepository
import com.example.propertymanagement.ui.login.LoginViewModel

@Suppress("UNCHECKED_CAST")
class LoginFactory(private var loginRepository: LoginRepository):
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

            return LoginViewModel(
                loginRepository
            ) as T
    }

}