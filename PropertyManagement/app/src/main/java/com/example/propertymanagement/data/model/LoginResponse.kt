package com.example.propertymanagement.data.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

data class LoginResponse(
    val token: String,
    val user: UserInfo
)

const val CURRENT_USER_ID = 0

@Entity(indices = [Index(value = ["email"], unique = true)])
data class UserInfo(
    val __v: Int,
    val _id: String,
    val createdAt: String,
    val email: String,
    val name: String,
    val password: String,
    val type: String
) {
    @PrimaryKey(autoGenerate = false)
   var uId: Int = CURRENT_USER_ID
}

data class RegisterResponse(
    val user: UserInfo,
    val error: Boolean,
    val message: String
)
