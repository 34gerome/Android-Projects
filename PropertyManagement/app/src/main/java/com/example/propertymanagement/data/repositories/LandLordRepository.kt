package com.example.propertymanagement.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.propertymanagement.data.model.GetPropertyResponse
import com.example.propertymanagement.data.model.PropertyInfo
import com.example.propertymanagement.data.network.ApiRequest
import com.example.propertymanagement.data.network.MyApi
import com.example.propertymanagement.database.MyDatabase
import com.example.propertymanagement.utils.CoRoutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.invoke
import kotlinx.coroutines.withContext

class LandLordRepository(private val myApi: MyApi, private val db: MyDatabase) : ApiRequest(){

    private val property = MutableLiveData<List<PropertyInfo>>()


    init {
        property.observeForever {
            saveProperty(it)
        }
    }

    //database insertion
    private fun saveProperty(it: List<PropertyInfo>) {

        //runs in IO thread and not main
        CoRoutines.io {
            db.getLandLordDao().insert(it)
        }
    }
    //database read property
    suspend fun getPropertyVM(): LiveData<List<PropertyInfo> > {
        return withContext(Dispatchers.IO) {
            db.getLandLordDao().getProperty()
        }
    }

    // get data from Api
    suspend fun fetchProperty() {
        if (fetcthPropertyNeeded()) {
            val response = myApi.getProperty()
            response.body()?.info.let {
                property.postValue(it)
            }

        }
    }

    private fun fetcthPropertyNeeded(): Boolean {
        return true
    }


}