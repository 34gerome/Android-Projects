package com.example.propertymanagement.di
//
//
//
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.example.propertymanagement.app.Config
//import com.example.propertymanagement.data.network.MyApi
//import com.example.propertymanagement.database.MyDatabase
//import dagger.Module
//import dagger.Provides
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.create
//import javax.inject.Singleton
//
//
//
//@Module
//class AppModule {
//
//    @Singleton
//    @Provides
//    fun provideRetrofitInstance(): MyApi {
//        return Retrofit.Builder()
//            .baseUrl(Config.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create()
//    }
//
//
//
//    @Provides
//    fun myDatabase(): RoomDatabase{
//         return Room.databaseBuilder(
//            context.applicationContext,
//            MyDatabase::class.java,
//            "mydb"
//        ).build()
//    }
//}