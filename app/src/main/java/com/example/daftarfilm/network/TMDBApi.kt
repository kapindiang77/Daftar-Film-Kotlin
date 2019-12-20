package com.example.daftarfilm.network

import com.example.daftarfilm.BuildConfig.API_KEY
import com.example.daftarfilm.BuildConfig.BASE_URL

object TMDBApi {
    fun getMovie(): String{
        return BASE_URL + API_KEY
    }
}