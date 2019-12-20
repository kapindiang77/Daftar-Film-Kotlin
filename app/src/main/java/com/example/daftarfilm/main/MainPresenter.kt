package com.example.daftarfilm.main

import com.example.daftarfilm.model.MovieResponse
import com.example.daftarfilm.network.ApiRepository
import com.example.daftarfilm.network.TMDBApi
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(private val view: MainView, private val apiRepository: ApiRepository, private val gson: Gson){
    fun getMovieList(){
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(TMDBApi.getMovie()),
                MovieResponse::class.java)
            uiThread {
                view.showMovieList(data.results)
            }
        }
    }
}