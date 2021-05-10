package com.example.myapplication.data.network

import com.example.myapplication.utils.APIExceptions
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.lang.StringBuilder

abstract class ApiRequest {

    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): T {
        var response = call.invoke()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            var error = response.errorBody()?.string()
            var message = StringBuilder()
            error?.let {
                try {
                    message.append(JSONObject(it).getString("message"))
                } catch (e: JSONException) {
                }
                message.append("\n")
            }
            message.append("Error Code: ${response.code()}")
            throw APIExceptions(message.toString())
        }

    }
}