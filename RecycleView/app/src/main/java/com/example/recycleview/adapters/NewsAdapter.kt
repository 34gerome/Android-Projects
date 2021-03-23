package com.example.recycleview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.R
import com.example.recycleview.models.News
import kotlinx.android.synthetic.main.row_news_adapter.view.*

class NewsAdapter(var mContext: Context, var mList: ArrayList<News>) :
    RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.MyViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.row_news_adapter, parent, false)
        var viewHolder = MyViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: NewsAdapter.MyViewHolder, position: Int) {
        var news = mList[position]
        holder.bind(news)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(news: News) {
            itemView.text_view_title.text = news.title
            itemView.text_view_description.text = news.description

            itemView.image_view_delete.setOnClickListener {
                mList.removeAt(position)
                notifyItemRemoved(position)

                itemView.setOnClickListener {
                    Toast.makeText(mContext, "Row Clicked", Toast.LENGTH_SHORT).show()
                }
                itemView.text_view_title.setOnClickListener {
                    Toast.makeText(mContext, news.title, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }




}