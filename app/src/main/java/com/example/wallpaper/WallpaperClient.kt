package com.example.wallpaper

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WallpaperClient {
    companion object{
        val BASE_URL = "https://api.pexels.com/v1/"
        lateinit var retrofit : Retrofit

        fun getWallpaper(): Retrofit {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit
        }
    }
}