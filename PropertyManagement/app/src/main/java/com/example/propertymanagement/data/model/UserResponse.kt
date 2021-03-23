package com.example.propertymanagement.data.model

data class UserResponse(
    val count: Int,
    val data: ArrayList<UserData>,
    val error: Boolean
)

data class UserData(
    val __v: Int,
    val _id: String,
    val createdAt: String,
    val email: String,
    val landlordEmail: String,
    val name: String,
    val password: String,
    val type: String
)