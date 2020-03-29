package com.example.movies

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie2.*
import org.json.JSONArray

class movie2 : AppCompatActivity() {

    lateinit var data: String
    lateinit var temp1: String
    lateinit var temp2: String
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie2)
        val b = intent.extras
        val t: String? = b!!.getString("mov")

        val queue = Volley.newRequestQueue(this)
        val url = "https://api.themoviedb.org/3/movie/${t}?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"

        val Json = JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            Response.Listener { response ->

                titleE.text = response.getString("title")
                originalTitleE.text = response.getString("original_title")
                yearE.text = response.getString("release_date")
                plotE.text = "Plot:-" + response.getString("overview")
                taglineE.text = "TagLine:-" + response.getString("tagline")
                languageE.text = "Languages:-" + response.getString("original_language")
                runtimeE.text = "Runtime:-" + response.getString("runtime")
                votesE.text = "Vote count:-" + response.getString("vote_count")
                votesAvgE.text = "Vote average:-" + response.getString("vote_average")
                popularityE.text = "Popularity:-" + response.getString("popularity")
                budgetE.text = "Budget:-" + response.getString("budget")
                revenueE.text = "Revenue:-" + response.getString("revenue")

                val a: String = response.getString("poster_path")
                Picasso.with(this).load("https://image.tmdb.org/t/p/w500${a}").into(movieViewE)

                val b: Boolean = response.getBoolean("adult")
                if (!b)
                    audienceE.text = "Audience:-All"
                else
                    audienceE.text = "Audience:-Adults Only"

                val jAr = response.getJSONArray("genres")
                var g: String = ""
                for (i in 0 until jAr.length() step 1) {
                    val j = jAr.getJSONObject(i)
                    g += j.getString("name") + ","
                }
                genreE.text = g

                val jAr2 = response.getJSONArray("production_countries")
                var f: String = ""
                for (i in 0 until jAr2.length() step 1) {
                    val j = jAr2.getJSONObject(i)
                    f += j.getString("name")
                }
                countryE.text = "Country:-$f"

                temp1 = response.getString("homepage")


                data =
                    "Title:-${response.getString("title")}\nOriginal Title:-${response.getString("original_title")}\nYear Released:-${response.getString(
                        "release_date"
                    )}\nGenre:-${g}\n\n\nPlot:-${response.getString("overview")}\n\nTagline:-${response.getString(
                        "tagline"
                    )}\n\nLanguage:-${response.getString("original_language")}\nRuntime:-${response.getString(
                        "runtime"
                    )}\nVotes:-${response.getString("vote_count")}\nRating:-${response.getString("vote_average")}\nPopularity:-${response.getString(
                        "popularity"
                    )}\nBudget:-${response.getString("budget")}\nRevenue:-${response.getString("revenue")}\n\nPoster:-${"https://image.tmdb.org/t/p/w500${a}"}"


            },
            Response.ErrorListener {
                plotE.text = "That didn't work!, Check your Internet Connection"
                data = "Due to error cannot load Movie Info,Check your internet connection"
            })
        queue.add(Json)

        homeE.setOnClickListener {
            val browser = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(temp1)
            )
            startActivity(browser)
        }
        youtubeE.setOnClickListener {

            val tmdb =
                "https://api.themoviedb.org/3/movie/100/videos?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
            val q = Volley.newRequestQueue(this)

            val j = JsonObjectRequest(
                Request.Method.GET,
                tmdb,
                null,
                Response.Listener {r->

                    val Ar=r.getJSONArray("results")
                    val obj=Ar.getJSONObject(0)
                    temp2="https://www.youtube.com/watch?v=${obj.getString("key")}"
                },
                Response.ErrorListener {
                    Toast.makeText(this,"No Trailer Found",Toast.LENGTH_SHORT).show()
                })
            q.add(j)
           Toast.makeText(this,"${temp2}",Toast.LENGTH_SHORT).show()

        }
        shareE.setOnClickListener {
            val i = Intent()
            i.action = Intent.ACTION_SEND
            i.putExtra(Intent.EXTRA_TEXT, data)
            i.type = "text/plain"
            startActivity(Intent.createChooser(i, "Share Movie Info to:-"))
        }
        heartE.setOnAnimationEndListener {
            Toast.makeText(this, "Added to Favorites", Toast.LENGTH_SHORT).show()
        }
        wishE.setOnAnimationEndListener {
            Toast.makeText(this, "Added to Wishlist", Toast.LENGTH_SHORT).show()
        }

    }
}
