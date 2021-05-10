package com.example.myapplication.data.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.model.Result
import com.example.myapplication.data.model.SuperHero
import com.example.myapplication.databinding.RowSuperheroHolderBinding

class AdapterSuperHero(var context: Context, var heroList: ArrayList<Result> ):
    RecyclerView.Adapter<AdapterSuperHero.MyViewHolder>() {
    class MyViewHolder(var binding: RowSuperheroHolderBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {

        var binding: RowSuperheroHolderBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_superhero_holder,
            parent,
            false
        )

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.supHero = heroList[position]
    }

    override fun getItemCount(): Int {
       return heroList.size
    }
}