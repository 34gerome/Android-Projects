package com.example.propertymanagement.ui.login

import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.propertymanagement.data.repositories.LoginRepository
import com.example.propertymanagement.ui.landlord.LandLordActivity
import com.example.propertymanagement.utils.APiExceptions
import com.example.propertymanagement.utils.CoRoutines


class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    var loginListner: LoginListner? = null

    var email: String? = null
    var password: String? = null

    fun getLoggedInUser() = loginRepository.getUserInfo()

    fun onLoginButtonClicked(view: View) {
        loginListner?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            // failed
            loginListner?.onFailure("Sorry invalid email or password")
        }

        CoRoutines.main {
            try {
                val loginResponse = loginRepository.login(email!!, password!!)
                loginResponse?.user?.let {
                    loginListner?.onSuccess(it)
                }

            } catch (e: APiExceptions) {
                loginListner?.onFailure(e.message!!)
            }
        }
        Intent(view.context, LandLordActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

    var type: String? = null
    var name: String? = null

    fun gotoRegister(view: View) {
        Intent(view.context, RegisterActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

    fun onRegisterButtonClicked(view: View) {
        loginListner?.onStarted()
        if (email.isNullOrEmpty()) {
            // failed
            loginListner?.onFailure("Email is Required")
            return
        }
        if (password.isNullOrEmpty()) {
            // failed
            loginListner?.onFailure("Password is Required")
            return
        }

        if (name.isNullOrEmpty()) {
            // failed
            loginListner?.onFailure("Name is Required")
            return
        }

        if (type.isNullOrEmpty()) {
            // failed
            loginListner?.onFailure("Type is Required")
            return
        }

        CoRoutines.main {

            try {
                val registerResponse = loginRepository.register(email!!, name!!, password!!, type!!)
                registerResponse?.body()?.user?.let {
                    loginListner?.onSuccess(it)
                }
            } catch (e: APiExceptions) {
                loginListner?.onFailure(e.message!!)
            }
            Intent(view.context, LoginActivity::class.java).also {
                view.context.startActivity(it)
            }
        }
    }
}