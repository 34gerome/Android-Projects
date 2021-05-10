package com.example.myapplication.ui.main.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.model.Result
import com.example.myapplication.data.repositories.MainRepository
import com.example.myapplication.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/*class MainViewModel constructor(@Inject val mainRepository: MainRepository) : ViewModel() {

    //mutablelive data store added list
    val heroes = MutableLiveData<ArrayList<Result>>()

    fun search(name: String) {
        viewModelScope.launch {
            try {
                val result = mainRepository.getCharacterBySearch(name)
                heroes.postValue(result.results)
            } catch (e: Exception) {

            }

        }

    }

}*/

class MainViewModel (var mainRepository: MainRepository) : ViewModel() {

    //mutablelive data store added list
    var heroes = MutableLiveData<ArrayList<Result>>()

    fun search(name: String) {
        viewModelScope.launch {
            try {
                var result = mainRepository.getCharacterBySearch(name)
                heroes.postValue(result.results)
            } catch (e: Exception) {

            }

        }

    }

}