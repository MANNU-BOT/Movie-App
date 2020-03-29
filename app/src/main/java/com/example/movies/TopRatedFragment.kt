package com.example.movies

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
import kotlinx.android.synthetic.main.fragment_top_rated.*

class TopRatedFragment : Fragment() {

    lateinit var elist: ArrayList<ExampleItemTR>
    lateinit var eadap: ExampleAdapterTR
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
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_top_rated, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainProgressBarTR.visibility = View.VISIBLE
        val h = Handler()
        h.postDelayed({
            elist = arrayListOf()

            val queue: RequestQueue = Volley.newRequestQueue(requireContext())
            val url =
                "https://api.themoviedb.org/3/movie/top_rated?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"

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
                        val b = j.getString("vote_average")
                        id = j.getString("id")
                        elist.add(ExampleItemTR(a, b, id))
                    }
                    eadap = ExampleAdapterTR(requireContext(), elist)
                    recyclerTR.adapter = eadap
                    recyclerTR.visibility = View.VISIBLE
                    mainProgressBarTR.visibility = View.GONE

                },
                Response.ErrorListener {
                    recyclerTR.visibility = View.GONE
                    mainProgressBarTR.visibility = View.GONE
                    Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                })
            queue.add(json)

        }, 1000)

        recyclerTR.setHasFixedSize(true)
        val manager = LinearLayoutManager(requireContext())
        recyclerTR.layoutManager = manager

        recyclerTR.addOnScrollListener(object : RecyclerView.OnScrollListener() {

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

            progressBarTR.visibility = View.VISIBLE
            h = Handler()
            h.postDelayed({

                val url =
                    "https://api.themoviedb.org/3/movie/top_rated?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2&page=$flag"
                val q = Volley.newRequestQueue(requireContext())

                val js = JsonObjectRequest(
                    Request.Method.GET,
                    url,
                    null,
                    Response.Listener { response ->
                        val JsAr = response.getJSONArray("results")

                        for (i in 0 until JsAr.length() step 1) {

                            val j = JsAr.getJSONObject(i)
                            val a = j.getString("poster_path")
                            val b = j.getString("vote_average")
                            id = j.getString("id")
                            elist.add(ExampleItemTR(a, b, id))
                        }
                        eadap.notifyDataSetChanged()
                        progressBarTR.visibility = View.GONE
                        flag += 1
                    },
                    Response.ErrorListener {
                        recyclerTR.visibility = View.GONE
                        progressBarTR.visibility = View.GONE
                        Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                    })
                q.add(js)


            }, 1000)


        }

    }


}
