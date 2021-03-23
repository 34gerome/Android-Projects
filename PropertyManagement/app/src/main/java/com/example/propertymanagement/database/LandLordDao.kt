package com.example.propertymanagement.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.propertymanagement.data.model.PropertyInfo


@Dao
interface LandLordDao {
    @Insert
    suspend fun insert(propertyInfo: List<PropertyInfo>)

    @Query("select * from PropertyInfo")
    fun getProperty(): LiveData<List<PropertyInfo>>


}