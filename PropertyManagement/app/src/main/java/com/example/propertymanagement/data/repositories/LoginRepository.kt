package com.example.propertymanagement.data.repositories

import com.example.propertymanagement.data.model.LoginResponse
import com.example.propertymanagement.data.model.RegisterResponse
import com.example.propertymanagement.data.model.UserInfo
import com.example.propertymanagement.data.network.ApiRequest
import com.example.propertymanagement.data.network.MyApi
import com.example.propertymanagement.database.MyDatabase
import retrofit2.Response

class LoginRepository(private val myApi: MyApi, private val db: MyDatabase): ApiRequest() {

    suspend fun login(email: String, password: String): LoginResponse {
        return apiRequest { myApi.login(email, password) }

    }

    suspend fun register(email: String, name: String, password: String, type: String): Response<RegisterResponse>{

        return myApi.register(name, email, password, type)
    }


  suspend   fun saveUserInfo(userInfo: UserInfo?) = userInfo?.let {
         db.getLoginDao().insert(it) }

    fun getUserInfo() = db.getLoginDao().getUser()
//
//    fun updateUser() = db.getLoginDao().update()
//    fun delete() = db.getLoginDao().delete()
//    fun getUserInfoById() = db.getLoginDao().getUserById()
//
}


