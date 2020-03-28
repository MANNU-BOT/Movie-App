package com.example.movies

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie.*
import org.json.JSONObject
import java.util.*

class movie : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie)

        val b = intent.extras
        titleD.text = b!!.getString("mov")
        heart.setOnAnimationEndListener {
            Toast.makeText(this, "Added to Favorites", Toast.LENGTH_SHORT).show()
        }

        val t: String? = b.getString("mov")

        val queue = Volley.newRequestQueue(this)
        val url = "https://www.omdbapi.com/?apikey=43bddbb&i=$t&plot=full"


        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->

                val j = JSONObject(response)

                titleD.text = j.getString("Title")
                yearD.text = j.getString("Released")
                genreD.text = j.getString("Genre")
                plotD.text = "Plot:-" + j.getString("Plot")
                starringD.text = "Actors:-" + j.getString("Actors")
                directorD.text = "Directors:-" + j.getString("Director")
                countryD.text = "Country:-" + j.getString("Country")
                LanguageD.text = "Language:-" + j.getString("Language")
                writerD.text = "Writers:-" + j.getString("Writer")
                ratingD.text = "IMDB rating:-" + j.getString("imdbRating")
                votesD.text = "IMDB votes:-" + j.getString("imdbVotes")
                awardD.text = "Awards:-" + j.getString("Awards")
                runtimeD.text = "Runtime:-" + j.getString("Runtime")
                typeD.text=j.getString("Type").toUpperCase(Locale.ROOT)
                val s = j.getString("Poster")
                Picasso.with(this).load(s).into(movieView)


            },
            Response.ErrorListener { plotD.text = "That didn't work!" })

        queue.add(stringRequest)


    }
}
