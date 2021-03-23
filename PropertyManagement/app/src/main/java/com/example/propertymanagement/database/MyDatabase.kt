package com.example.propertymanagement.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.propertymanagement.data.model.PropertyInfo
import com.example.propertymanagement.data.model.UserInfo


@Database(entities = [UserInfo::class, PropertyInfo::class], version = 2)
abstract class MyDatabase: RoomDatabase() {

    abstract fun getLoginDao(): LoginDao
    abstract fun getLandLordDao(): LandLordDao

    companion object{

        //immediately visible to all other threads
        @Volatile
        private var instance : MyDatabase? = null
        private var LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance?:buildDatabase(context).also {
                //assign database to the instance
                instance = it
            }
        }

        //returning database
    private fun buildDatabase(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            MyDatabase::class.java,
            "mydb"
        ).build()
    }
}