package com.example.wallpaper

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.wallpaper.databinding.WallpaperItemBinding

class WallpaperAdapter : RecyclerView.Adapter<WallpaperAdapter.WallpaperHolder>() {

    lateinit var context: Context
    var photo = ArrayList<PhotosItem>()

    class WallpaperHolder(itemView: WallpaperItemBinding) : ViewHolder(itemView.root){
        var binding = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WallpaperHolder {
        context = parent.context
        var binding = WallpaperItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return WallpaperHolder(binding)
    }

    override fun getItemCount(): Int {
        return photo.size
    }

    override fun onBindViewHolder(holder: WallpaperHolder, position: Int) {
        holder.binding.apply {
            photo.get(position)?.src?.apply {
                Glide.with(context).load(portrait).into(imgWallpaper)
            }
        }
    }

    fun setPhoto(photo: List<PhotosItem?>?) {
        this.photo = photo as ArrayList<PhotosItem>
    }
}