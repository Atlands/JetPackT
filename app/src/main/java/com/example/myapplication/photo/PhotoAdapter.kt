package com.example.myapplication.photo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.http.PhotoItem
import kotlinx.android.synthetic.main.pager_photo_cell.view.*

class PhotoAdapter : ListAdapter<PhotoItem, MyViewHolder>(
    Diffcallback
) {
    object Diffcallback : DiffUtil.ItemCallback<PhotoItem>() {
        override fun areItemsTheSame(oldItem: PhotoItem, newItem: PhotoItem): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: PhotoItem, newItem: PhotoItem): Boolean {
            return oldItem.photoId == newItem.photoId
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.pager_photo_cell, parent, false)
            .apply {
                return MyViewHolder(this)
            }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(getItem(position).fullUrl)
            .placeholder(R.drawable.photo_placeholder).into(holder.itemView.ing_pager_photo)
    }
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)