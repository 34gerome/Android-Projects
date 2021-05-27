package com.example.myapplication.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    @Inject lateinit var myApi: MyApi
   // @Inject lateinit var mainRepository: MainRepository
   // lateinit var  myApi: MyApi
    lateinit var adapter: AdapterSuperHero
    lateinit var binding: ActivityMainBinding // view binding
    private val TAG = "abc"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       //setContentView(R.layout.activity_main)

        FirebaseMessaging.getInstance().isAutoInitEnabled = true
        var token = FirebaseMessaging.getInstance().token
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w(TAG, "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            val t = task.result

            Log.d(TAG, "onNewToken: Token: $token")
            Log.d(TAG, "onNewToken: Task: $t")
            Toast.makeText(baseContext, t, Toast.LENGTH_SHORT).show()
        })
        Log.d(TAG, "onCreate: Token: $token")

         binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        (application as? MyApplication)?.component?.inject(this)
      //   myApi = MyApi()
        var mainRepository = MainRepository(myApi)



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
            adapter.onSuperHeroSelected = {
                hero,position ->
                Toast.makeText(applicationContext, "SuperHero: ${hero.name}", Toast.LENGTH_LONG).show()
                var intent = Intent(this, SuperHeroActivity::class.java)
                intent.putExtra("hero", hero)
                startActivity(intent)
            }
            binding.recyclerView.adapter = adapter
        })
    }
}