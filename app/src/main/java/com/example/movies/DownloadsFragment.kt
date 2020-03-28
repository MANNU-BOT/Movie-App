package com.example.movies

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.fragment_downloads.*

@Suppress("DEPRECATION", "PLUGIN_WARNING")
class DownloadsFragment : Fragment() {

    var p: Int = 0
    var flag: Int = 2
    lateinit var id: String
    lateinit var elist: ArrayList<ExampleItem>
    lateinit var eadap: ExampleAdapter
    var isScrolling: Boolean = false
    var curItem: Int = 0
    var totItem: Int = 0
    var scrOutItem: Int = 0
    lateinit var s: String
    lateinit var y: String
    lateinit var h: Handler

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_downloads, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchTitle.setOnClickListener {
            tab.visibility=View.VISIBLE
            noOfResults.visibility=View.GONE
        }

        searchButtonMain.setOnClickListener {

            mainProgressBar.visibility=View.VISIBLE
            val h=Handler()
            h.postDelayed({
                tab.visibility=View.GONE
                noOfResults.visibility=View.VISIBLE
                elist = arrayListOf()
                s = searchTitle.text.toString()
                y = searchYear.text.toString()
                val queue: RequestQueue = Volley.newRequestQueue(requireContext())
                val omdb = "https://www.omdbapi.com/?apikey=43bddbb&s=$s&y=$y"


                val json = JsonObjectRequest(
                    Request.Method.GET,
                    omdb,
                    null,
                    Response.Listener { response ->
                        if (response.getString("Response") == "True") {
                            p = ((response.getString("totalResults").toInt()) / 10) + 1
                            val noOfRes: String = response.getString("totalResults")
                            noOfResults.text= "Total Results:-$noOfRes"
                            val JsonAr = response.getJSONArray("Search")

                            for (i in 0 until JsonAr.length() step 1) {
                                val j = JsonAr.getJSONObject(i)
                                val a = j.getString("Title")
                                val b = "Year:-" + j.getString("Year")
                                id = j.getString("imdbID")
                                val e = j.getString("Poster")
                                elist.add(ExampleItem(a, b, e,id))
                            }
                            eadap = ExampleAdapter(requireContext(), elist)
                            recycler.adapter = eadap
                            recycler.visibility = View.VISIBLE
                            mainProgressBar.visibility=View.GONE
                        } else {
                            recycler.visibility = View.GONE
                            mainProgressBar.visibility=View.GONE
                            Toast.makeText(requireContext(), "Not Found :( ", Toast.LENGTH_SHORT).show()
                            noOfResults.text="Total Results:- 0 {not found}"
                        }
                    },
                    Response.ErrorListener {
                        recycler.visibility = View.GONE
                        Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                    })
                queue.add(json)

            },1000)



            recycler.setHasFixedSize(true)
            val manager = LinearLayoutManager(requireContext())
            recycler.layoutManager = manager

            recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {

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


                        if (p == 1) {
                            Toast.makeText(requireContext(), "No More Results", Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            fetchMoreData(p)
                        }


                    }
                }
            })
        }
    }

    private fun fetchMoreData(page: Int) {

        if (flag > page) {
            Toast.makeText(requireContext(), "No more results", Toast.LENGTH_SHORT).show()
        } else {
            progressBar.visibility = View.VISIBLE

            h = Handler()
            h.postDelayed({

                val url = "https://www.omdbapi.com/?apikey=43bddbb&s=$s&y=$y&page=$flag"
                val q = Volley.newRequestQueue(requireContext())
                val js = JsonObjectRequest(
                    Request.Method.GET,
                    url,
                    null,
                    Response.Listener { response ->
                        val JsAr = response.getJSONArray("Search")

                        for (i in 0 until JsAr.length() step 1) {
                            val j = JsAr.getJSONObject(i)
                            val a = j.getString("Title")
                            val b = "Year:-" + j.getString("Year")
                            id = j.getString("imdbID")
                            val e = j.getString("Poster")
                            elist.add(ExampleItem(a, b, e,id))
                        }
                        eadap.notifyDataSetChanged()
                        progressBar.visibility = View.GONE
                    },
                    Response.ErrorListener {
                        recycler.visibility = View.GONE
                        Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                    })
                q.add(js)
            }, 1000)
            flag += 1
        }

    }

}//end





