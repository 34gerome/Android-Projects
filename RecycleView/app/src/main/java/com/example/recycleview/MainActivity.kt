package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleview.adapters.NewsAdapter
import com.example.recycleview.models.News
import kotlinx.android.synthetic.main.activity_main.*

var mList: ArrayList<News> = ArrayList()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    init()
    }


    private fun init() {
        generateData()

        var adapterNews = NewsAdapter (this, mList)
        recycler_view.adapter = adapterNews
        recycler_view.layoutManager = LinearLayoutManager(this)

    }

    private fun generateData(){
        mList.add(News("Title 1", "Description 1"))
        mList.add(News("Title 2", "Description 2"))
        mList.add(News("Title 3", "Description 3"))
        mList.add(News("Title 4", "Description 4"))
    }
}