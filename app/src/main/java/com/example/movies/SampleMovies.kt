//NOT WORKING


package com.example.movies

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sample_movies.*


@Suppress("DEPRECATION")
class SampleMovies : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_movies)

        val bun = intent.extras

        when (bun!!.getString("key")) {

            "one" -> {
                actionGrid.visibility = View.VISIBLE
                categoryName.text = "ACTION"
            }
            "two" -> {
                comedyGrid.visibility = View.VISIBLE
                categoryName.text = "COMEDY"
            }
            "three" -> {
                HorrorGrid.visibility = View.VISIBLE
                categoryName.text = "HORROR"
            }
            "four" -> {
                animGrid.visibility = View.VISIBLE
                categoryName.text = "ANIMATED"
            }
            "five" -> {
                animeGrid.visibility = View.VISIBLE
                categoryName.text = "ANIME"
            }
            else -> {
                animeGrid.visibility = View.VISIBLE
                categoryName.text = "ERROR"
            }
        }


    }
}

