package com.example.daftarfilm.main

import com.example.daftarfilm.model.Movie

interface MainView{
    fun showMovieList(data: List<Movie>)
}