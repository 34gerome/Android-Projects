package com.example.myapplication.data.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.repositories.MainRepository
import com.example.myapplication.ui.main.viewModel.MainViewModel
import javax.inject.Inject


/*
@Suppress("UNCHECKED_CAST")
class MainViewModelFactory constructor(@Inject val mainRepository: MainRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(
            mainRepository
        ) as T
    }
}*/

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(var mainRepository: MainRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(
            mainRepository
        ) as T
    }
}
