package com.example.propertymanagement.ui.login

import com.example.propertymanagement.data.model.UserInfo

interface LoginListner {
    fun onStarted()
    fun onSuccess(userInfo: UserInfo)
    fun onFailure(message: String)
}