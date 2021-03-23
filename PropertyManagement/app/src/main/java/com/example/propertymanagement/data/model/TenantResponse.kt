package com.example.propertymanagement.data.model

data class TenantResponse(
    val count: Int,
    val data: ArrayList<TenantData>,
    val error: Boolean
)

data class TenantData(
    val __v: Int,
    val _id: String,
    val email: String,
    val landlordId: String,
    val mobile: String,
    val name: String
)