package com.example.movies

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
import kotlinx.android.synthetic.main.fragment_latest.*
import android.os.Bundle as Bundle1


class LatestFragment : Fragment() {

    lateinit var elist: ArrayList<ExampleItemLA>
    lateinit var eadap: ExampleAdapterLA
    lateinit var id: String
    var p: Int = 0
    var flag: Int = 2
    var isScrolling: Boolean = false
    var curItem: Int = 0
    var totItem: Int = 0
    var scrOutItem: Int = 0
    lateinit var h: Handler
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle1?
    ): View? {
        return inflater.inflate(R.layout.fragment_latest, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: android.os.Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainProgressBarLA.visibility = View.VISIBLE
        val h = Handler()
        h.postDelayed({
            elist = arrayListOf()

            val queue: RequestQueue = Volley.newRequestQueue(requireContext())
            val url =
                "https://api.themoviedb.org/3/movie/upcoming?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"

            val json = JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                Response.Listener { response ->
                    flag = 2
                    p = response.getString("total_pages").toInt()
                    val JsonAr = response.getJSONArray("results")

                    for (i in 0 until JsonAr.length() step 1) {

                        val j = JsonAr.getJSONObject(i)
                        val a = j.getString("poster_path")
                        val b = j.getString("title")
                        val c = j.getString("popularity")
                        val d = j.getString("release_date")
                        id = j.getString("id")
                        elist.add(ExampleItemLA(a, b, c, d, id))
                    }
                    eadap = ExampleAdapterLA(requireContext(), elist)
                    recyclerLA.adapter = eadap
                    recyclerLA.visibility = View.VISIBLE
                    mainProgressBarLA.visibility = View.GONE
                },
                Response.ErrorListener {
                    recyclerLA.visibility = View.GONE
                    mainProgressBarLA.visibility = View.GONE
                    Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                })
            queue.add(json)

        }, 1000)

        recyclerLA.setHasFixedSize(true)
        val manager = LinearLayoutManager(requireContext())
        recyclerLA.layoutManager = manager

        recyclerLA.addOnScrollListener(object : RecyclerView.OnScrollListener() {

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

    private fun fetchMoreData(page: Int) {

        if (flag > page) {
            Toast.makeText(requireContext(), "No more results ...", Toast.LENGTH_SHORT).show()
        } else {
            progressBarLA.visibility = View.VISIBLE
            h = Handler()
            h.postDelayed({

                val url =
                    "https://api.themoviedb.org/3/movie/upcoming?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2&page=${flag}"
                val q: RequestQueue = Volley.newRequestQueue(requireContext())

                val js = JsonObjectRequest(
                    Request.Method.GET,
                    url,
                    null,
                    Response.Listener { response ->

                        val JsAr = response.getJSONArray("results")
                        for (i in 0 until JsAr.length() step 1) {

                            val j = JsAr.getJSONObject(i)
                            val a = j.getString("poster_path")
                            val b = j.getString("title")
                            val c = j.getString("popularity")
                            val d = j.getString("release_date")
                            id = j.getString("id")
                            elist.add(ExampleItemLA(a, b, c, d, id))
                        }
                        eadap.notifyDataSetChanged()
                        progressBarLA.visibility = View.GONE
                        flag += 1

                    },
                    Response.ErrorListener {
                        recyclerLA.visibility = View.GONE
                        progressBarLA.visibility = View.GONE
                        Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                    })
                q.add(js)
            }, 1000)
        }

    }
}

