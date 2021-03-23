package com.example.propertymanagement.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class PropertyResponse(
    val info: List<PropertyInfo>,
    val error: Boolean,
    val message: String
)

@Entity
data class PropertyInfo(
    @PrimaryKey(autoGenerate = false)
    val __v: Int,
    val _id: String,
    val image: String,
    val mortageInfo: Boolean,
    val propertyStatus: Boolean
)

data class GetPropertyResponse(
    val error: Boolean,
    val count: Int,
    val info: List<PropertyInfo>

)