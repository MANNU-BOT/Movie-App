package com.example.movies

import android.annotation.SuppressLint
import android.content.Intent
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

    lateinit var data: String
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie)

        val b = intent.extras
        titleD.text = b!!.getString("mov")


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
                typeD.text = j.getString("Type").toUpperCase(Locale.ROOT)
                val s = j.getString("Poster")
                if (s == "N/A")
                    Picasso.with(this).load("https://lh3.googleusercontent.com/proxy/CccEHvVgQvpSEUBlRgCwG2ohovqp_sHRAsQL2swS-4qFmCAWhF-VRmVuLTBHPXC4R7kIXCMXQ3hvF2FTlyEu9eWOki-EiptK0ZIo8g").into(
                        movieView
                    )
                else
                    Picasso.with(this).load(s).into(movieView)

                data =
                    "Movie Name:-${j.getString("Title")}\nReleased on:-${j.getString("Released")}\nGenre:-${j.getString(
                        "Genre"
                    )}\n\n\n" +
                            "Plot:-${j.getString("Plot")}\n\nDirector:-${j.getString("Director")}\n\n" +
                            "Actors:-${j.getString("Actors")}IMDB rating:-${j.getString("imdbRating")}\n\nAwards:-${j.getString(
                                "Awards"
                            )}\n" +
                            "Poster Link:-${j.getString("Poster")}\n\n\nThis data is sent from Movies App which uses OMDB Api"

            },
            Response.ErrorListener {
                plotD.text = "That didn't work!, Check your Internet Connection"
                data = "Due to error cannot load Movie Info,Check your internet connection"
            })

        queue.add(stringRequest)

        shareD.setOnClickListener {

            val i = Intent()
            i.action = Intent.ACTION_SEND
            i.putExtra(Intent.EXTRA_TEXT, data)
            i.type = "text/plain"
            startActivity(Intent.createChooser(i, "Share Movie Info to:-"))
        }
        heart.setOnAnimationEndListener {
            Toast.makeText(this, "Added to Favorites", Toast.LENGTH_SHORT).show()
        }
        wishD.setOnAnimationEndListener {
            Toast.makeText(this, "Added to Wishlist", Toast.LENGTH_SHORT).show()
        }

    }
}
