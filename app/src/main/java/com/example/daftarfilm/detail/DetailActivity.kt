package com.example.daftarfilm.detail

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.daftarfilm.BuildConfig.URL_POSTER
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    private var titleMovie: String = ""
    private var posterMovie: String = ""
    private var overviewMovie: String = ""

    private lateinit var poster: ImageView
    private lateinit var title: TextView
    private lateinit var overview: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        linearLayout {
            lparams(width = matchParent, height = wrapContent)
            orientation = LinearLayout.VERTICAL
            padding = dip(16)

            poster = imageView{

            }.lparams{
                width = dip(250)
                gravity = Gravity.CENTER
                height = dip(250)
            }

            title = textView{
                textSize = 15f
                typeface = Typeface.DEFAULT_BOLD
                gravity = Gravity.CENTER
            }
            overview = textView{
                width = wrapContent
            }


        }

        val i = intent
        titleMovie = i.getStringExtra("TITLE")
        posterMovie = i.getStringExtra("POSTER")
        overviewMovie = i.getStringExtra("OVERVIEW")

        title.text = titleMovie
        overview.text = overviewMovie
        Picasso.get().load(URL_POSTER + posterMovie).into(poster)

    }
}
