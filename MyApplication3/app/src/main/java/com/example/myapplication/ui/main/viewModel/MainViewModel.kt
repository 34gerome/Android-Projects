package com.example.myapplication.ui.main.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.model.SuperHero
import com.example.myapplication.data.repositories.MainRepository
import kotlinx.coroutines.launch

class MainViewModel (var mainRepository: MainRepository) : ViewModel() {

    //mutablelive data store added list
    var heroes = MutableLiveData<ArrayList<SuperHero>>()

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