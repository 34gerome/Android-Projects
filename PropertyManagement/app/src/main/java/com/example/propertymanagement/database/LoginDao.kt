package com.example.propertymanagement.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.propertymanagement.data.model.CURRENT_USER_ID
import com.example.propertymanagement.data.model.UserInfo


@Dao
interface LoginDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insert(user: UserInfo)

    @Update
    fun update(user: UserInfo)

    @Delete
    fun delete(user: UserInfo)

    @Query("select * from UserInfo where uId = $CURRENT_USER_ID ")
    fun getUserById(): LiveData<UserInfo>

    @Query("select * from UserInfo")
    fun getUser(): LiveData<UserInfo>



}