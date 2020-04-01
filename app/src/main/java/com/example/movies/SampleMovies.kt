//NOT WORKING


package com.example.movies

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.AbsListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_sample_movies.*


@Suppress("DEPRECATION")
class SampleMovies : AppCompatActivity() {
    lateinit var id: String
    var p = 1
    var isScrolling: Boolean = false
    var curItem: Int = 0
    var totItem: Int = 0
    var scrOutItem: Int = 0
    lateinit var elist: ArrayList<ExampleItemHM>
    lateinit var eadap: ExampleAdapterHM
    lateinit var url: String
    lateinit var url2: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_movies)

        val b = intent.extras

        val s = b!!.getString("key")

        when (s) {

            "one" -> {
                url =
                    "https://api.themoviedb.org/3/movie/87101/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
                url2 =
                    "https://api.themoviedb.org/3/movie/245891/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
                gridTitle.text=getString(R.string.Action)
            }
            "two" -> {
                url =
                    "https://api.themoviedb.org/3/movie/353486/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
                url2 =
                    "https://api.themoviedb.org/3/movie/448119/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
                gridTitle.text=getString(R.string.Comedy)

            }
            "three" -> {
                url =
                    "https://api.themoviedb.org/3/movie/619264/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
                url2 =
                    "https://api.themoviedb.org/3/movie/619264/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2&page=2"
                gridTitle.text=getString(R.string.horror)

            }
            "four" -> {
                url =
                    "https://api.themoviedb.org/3/movie/109445/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
                url2 =
                    "https://api.themoviedb.org/3/movie/109445/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2&page=2"
                gridTitle.text=getString(R.string.Animated)

            }
            "five" -> {
                url =
                    "https://api.themoviedb.org/3/movie/372058/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
                url2 =
                    "https://api.themoviedb.org/3/movie/347201/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
                gridTitle.text=getString(R.string.Anime)

            }
            "six" -> {
                url =
                    "https://api.themoviedb.org/3/movie/371645/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
                url2 =
                    "https://api.themoviedb.org/3/movie/550/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
                gridTitle.text=getString(R.string.Hollywood)

            }
            "seven" -> {
                url =
                    "https://api.themoviedb.org/3/movie/89458/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
                url2 =
                    "https://api.themoviedb.org/3/movie/136799/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
                gridTitle.text=getString(R.string.Kids)

            }
            "eight" -> {
                url =
                    "https://api.themoviedb.org/3/movie/465642/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
                url2 =
                    "https://api.themoviedb.org/3/movie/465642/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2&page=2"
                gridTitle.text=getString(R.string.bollywood)

            }
            else -> {
                url =
                    "https://api.themoviedb.org/3/movie/550/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
                url2 =
                    "https://api.themoviedb.org/3/movie/550/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2&page=2"
                gridTitle.text=getString(R.string.error)

            }
        }

        Recycler()
    }

    fun Recycler() {

        val h = Handler()
        h.postDelayed({
            parseJSON(url)
        }, 1000)

    }

    private fun parseJSON(url: String) {

        progressGrid.visibility = View.VISIBLE
        val URL = url
        val h = Handler()
        h.postDelayed({
            elist = arrayListOf()

            val queue: RequestQueue = Volley.newRequestQueue(this)
            val json = JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                Response.Listener { response ->

                    val JsonAr = response.getJSONArray("results")

                    for (i in 0 until JsonAr.length() step 1) {

                        val j = JsonAr.getJSONObject(i)
                        val a = j.getString("poster_path")
                        id = j.getString("id")
                        val b = j.getString("vote_count")
                        val c = j.getString("vote_average")
                        elist.add(ExampleItemHM(a, id, b, c))
                    }
                    eadap = ExampleAdapterHM(this, elist)
                    eadap.notifyDataSetChanged()
                    recyclerGrid.adapter = eadap
                    recyclerGrid.visibility = View.VISIBLE
                    progressGrid.visibility = View.GONE
                },
                Response.ErrorListener {
                    recyclerGrid.visibility = View.GONE
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                })
            queue.add(json)
        }, 1000)

        recyclerGrid.setHasFixedSize(true)
        val manager = GridLayoutManager(this, 3)
        recyclerGrid.layoutManager = manager


        recyclerGrid.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    isScrolling = true
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                curItem = manager.childCount
                totItem = manager.itemCount
                scrOutItem = manager.findFirstVisibleItemPosition()

                if ((isScrolling) && (curItem + scrOutItem == totItem)) {

                    isScrolling = false

                    if (p > 1)
                        Toast.makeText(
                            this@SampleMovies,
                            "No more results",
                            Toast.LENGTH_SHORT
                        ).show()
                    else
                        fetchNextPage()
                }
            }
        })
    }

    private fun fetchNextPage() {

        val ha = Handler()
        ha.postDelayed({
            progressGridBottom.visibility = View.VISIBLE
            val queue: RequestQueue = Volley.newRequestQueue(this)
            val json = JsonObjectRequest(
                Request.Method.GET,
                url2,
                null,
                Response.Listener { response ->

                    val JsonAr = response.getJSONArray("results")

                    for (i in 0 until JsonAr.length() step 1) {

                        val j = JsonAr.getJSONObject(i)
                        val a = j.getString("poster_path")
                        id = j.getString("id")
                        val b = j.getString("vote_count")
                        val c = j.getString("vote_average")
                        elist.add(ExampleItemHM(a, id, b, c))
                    }
                    eadap = ExampleAdapterHM(this, elist)
                    eadap.notifyDataSetChanged()
                    recyclerGrid.adapter = eadap
                    recyclerGrid.visibility = View.VISIBLE
                    progressGridBottom.visibility = View.GONE
                    p = 2
                },
                Response.ErrorListener {
                    recyclerGrid.visibility = View.GONE
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                })
            queue.add(json)
        }, 100)

    }


}

