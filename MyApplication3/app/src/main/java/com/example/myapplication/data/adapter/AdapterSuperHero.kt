package com.example.myapplication.data.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.model.SearchResult
import com.example.myapplication.data.model.SuperHero
import com.example.myapplication.databinding.RowSuperheroHolderBinding
import com.example.myapplication.ui.main.view.SuperHeroActivity
import java.io.Serializable

class AdapterSuperHero(var context: Context, var heroList: ArrayList<SuperHero>) : // superher adapter
    RecyclerView.Adapter<AdapterSuperHero.MyViewHolder>() {

    lateinit var onSuperHeroSelected: ((SuperHero, Int)-> Unit)

    inner class MyViewHolder(var binding: RowSuperheroHolderBinding) :
        RecyclerView.ViewHolder(binding.root) {
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

        holder.binding.rootLayout.setOnClickListener {
            val selectedHero = heroList[position]
            onSuperHeroSelected(selectedHero, position)
          /*  var intent = Intent(context, SuperHeroActivity::class.java)
            var bundle = Bundle()
            bundle.putParcelable("hero", selectedHero)
            intent.putExtra("DATA", heroList)
            context.startActivity(intent)*/
        }
    }

    override fun getItemCount(): Int {
        return heroList.size
    }
}