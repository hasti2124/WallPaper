package com.example.wallpaper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wallpaper.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var auth = "3L9fjpW2qNvRFpP62T3Vd4ZGouHrrLI5AA3Xh9jTml2eEbE5ELmTGEEY"
    var adapter = WallpaperAdapter()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = WallpaperAdapter()

        binding.btnSearch.setOnClickListener {

            wallpaperApi()
        }
    }

    private fun wallpaperApi() {
        var txt = binding.edtSearch.text.toString()

        var api = WallpaperClient.getWallpaper().create(WallpaperInterface::class.java)
        api.getWallpaperInterface(auth,txt).enqueue(object : Callback<WallpaperModel>{
            override fun onResponse(
                call: Call<WallpaperModel>,
                response: Response<WallpaperModel>
            ) {
                if(response.isSuccessful){
                    var photo = response.body()?.photos
                    adapter.setPhoto(photo)
                    binding.rcvPhoto.layoutManager = GridLayoutManager(this@MainActivity,2)
                    binding.rcvPhoto.adapter = adapter
                }
            }

            override fun onFailure(call: Call<WallpaperModel>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}