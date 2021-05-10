package com.example.myapplication.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.data.adapter.AdapterSuperHero
import com.example.myapplication.data.factory.MainViewModelFactory
import com.example.myapplication.data.network.MyApi
import com.example.myapplication.data.repositories.MainRepository
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.main.viewModel.MainViewModel
import com.example.myapplication.utils.MyApplication
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    @Inject lateinit var myApi: MyApi
   // @Inject lateinit var mainRepository: MainRepository
    lateinit var adapter: AdapterSuperHero
    lateinit var binding: ActivityMainBinding // view binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       //setContentView(R.layout.activity_main)

        (application as? MyApplication)?.component?.inject(this)

        var mainRepository = MainRepository(myApi)

        var binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        var mainFactory = MainViewModelFactory(mainRepository)

        viewModel = ViewModelProvider(this, mainFactory)
            .get(MainViewModel::class.java)

        binding.buttonSearch.setOnClickListener{
            var name = binding.edName.text.toString()
            viewModel.search(name)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        setUpObservers()
    }

    fun setUpObservers(){
        viewModel.heroes.observe(this,{
            adapter = AdapterSuperHero(this, it )
            binding.recyclerView.adapter = adapter
        })
    }
}