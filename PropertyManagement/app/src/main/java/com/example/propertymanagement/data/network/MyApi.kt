package com.example.propertymanagement.data.network


import com.example.propertymanagement.app.Config
import com.example.propertymanagement.app.Endpoints
import com.example.propertymanagement.data.model.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


interface MyApi {

    @FormUrlEncoded
    @POST("auth/login")
   suspend fun login(
        @Field("email")email:String,
        @Field("password")password:String
    ): Response<LoginResponse>

    @FormUrlEncoded
    @POST("auth/register/")
    suspend fun register(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("type") type: String
    ): Response<RegisterResponse>

    @GET("users/")
    fun getUSER(@Path("userId")userId: Int): Call<UserResponse>

    @GET("property/")
    suspend fun getProperty(): Response<PropertyResponse>

    @FormUrlEncoded
    @POST("property/")
    suspend fun postProperty(
        @Field("address") address: String,
        @Field("city") city: String,
        @Field("purchasePrice") purchasePrice: Int,
        @Field("state") state: String,
    ): Response<PropertyResponse>





// @inject myapi dagger
    companion object{
        operator fun invoke():MyApi{
            return Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}