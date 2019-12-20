package com.example.daftarfilm.main

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.daftarfilm.BuildConfig.URL_POSTER
import com.example.daftarfilm.R
import com.example.daftarfilm.R.id.*
import com.example.daftarfilm.model.Movie
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainAdapter(private val result: List<Movie>, private val listener: (Movie) -> Unit) : RecyclerView.Adapter<MovieViewHolder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MovieViewHolder {
        return MovieViewHolder(MovieUI().createView(AnkoContext.create(p0.context, p0)))
    }

    override fun getItemCount(): Int = result.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindItem(result[position], listener)
    }


}

class MovieUI : AnkoComponent<ViewGroup>{
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui){
            linearLayout{
                lparams(width = matchParent, height = wrapContent)
                padding = dip(5)
                orientation = LinearLayout.VERTICAL

                imageView {
                    id = R.id.movie_poster
                }.lparams {
                    height = dip(250)
                    width = wrapContent
                }

                textView{
                    id = R.id.movie_title
                    textSize = 15f
                }.lparams{
                    margin = dip(18)
                }
            }
        }
    }
}

class MovieViewHolder(view: View) :RecyclerView.ViewHolder(view){
    private val moviePoster: ImageView = view.find(movie_poster)
    private val movieTitle: TextView = view.find(movie_title)

    fun bindItem(movies: Movie, listener: (Movie) -> Unit){
        Picasso.get().load(URL_POSTER + movies.poster).into(moviePoster)
        movieTitle.text = movies.title

        moviePoster.onClick { listener(movies) }
    }
}