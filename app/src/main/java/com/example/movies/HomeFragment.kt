package com.example.movies

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.fragment_home.*

@Suppress("UNREACHABLE_CODE")
class HomeFragment : Fragment() {



    lateinit var id: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AllButtons()
        Recycler1()
        Recycler2()
        Recycler3()
        Recycler4()
        Recycler5()
        Recycler6()
        Recycler7()
        Recycler8()
        Recycler9()
        Recycler10()
    }


    fun AllButtons() {
        block1.setOnClickListener {
            val i = Intent(requireContext(), SampleMovies::class.java)
            i.putExtra("key", "one")
            startActivity(i)
        }
        block2.setOnClickListener {
            val i = Intent(requireContext(), SampleMovies::class.java)
            i.putExtra("key", "three")
            startActivity(i)
        }
        block3.setOnClickListener {
            val i = Intent(requireContext(), SampleMovies::class.java)
            i.putExtra("key", "two")
            startActivity(i)
        }
        block4.setOnClickListener {
            val i = Intent(requireContext(), SampleMovies::class.java)
            i.putExtra("key", "five")
            startActivity(i)
        }
        block5.setOnClickListener {
            val i = Intent(requireContext(), SampleMovies::class.java)
            i.putExtra("key", "four")
            startActivity(i)
        }
        block6.setOnClickListener {
            val i = Toast.makeText(requireContext(), "Not Available", Toast.LENGTH_SHORT)
            i.setGravity(Gravity.CENTER, 0, 0)
            i.show()
        }
    }


    private fun Recycler1() {

        val url =
            "https://api.themoviedb.org/3/movie/550/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
        parseJSON(url, recycler1)
    }

    private fun Recycler2() {

        val url =
            "https://api.themoviedb.org/3/movie/157336/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
        parseJSON(url, recycler2)

    }

    private fun Recycler3() {

        val url =
            "https://api.themoviedb.org/3/movie/371645/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
        parseJSON(url, recycler3)
    }

    private fun Recycler4() {
        val url =
            "https://api.themoviedb.org/3/movie/19404/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
        parseJSON(url, recycler4)
    }

    private fun Recycler5() {
        val url =
            "https://api.themoviedb.org/3/movie/19404/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
        parseJSON(url, recycler5)
    }

    private fun Recycler6() {
        val url =
            "https://api.themoviedb.org/3/movie/19404/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
        parseJSON(url, recycler6)
    }

    private fun Recycler7() {
        val url =
            "https://api.themoviedb.org/3/movie/550/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
        parseJSON(url, recycler7)
    }

    private fun Recycler8(){
        val url= "https://api.themoviedb.org/3/movie/157336/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
        parseJSON(url,recycler8)
    }

    private fun Recycler9(){
        val url= "https://api.themoviedb.org/3/movie/157336/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
        parseJSON(url,recycler9)
    }

    private fun Recycler10(){
        val url= "https://api.themoviedb.org/3/movie/157336/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
        parseJSON(url,recycler10)
    }


    private fun parseJSON(url: String, recyclerView: RecyclerView) {

        var elist: ArrayList<ExampleItemHM>
        var eadap: ExampleAdapterHM
        var rec = recyclerView
        val URL = url
        val h = Handler()
        h.postDelayed({
            elist = arrayListOf()

            val queue: RequestQueue = Volley.newRequestQueue(requireContext())
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
                    eadap = ExampleAdapterHM(requireContext(), elist)
                    eadap.notifyDataSetChanged()
                    rec.adapter = eadap
                    rec.visibility = View.VISIBLE
                },
                Response.ErrorListener {
                    rec.visibility = View.GONE
                    Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                })
            queue.add(json)
        }, 1000)

        rec.setHasFixedSize(true)
        val manager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rec.layoutManager = manager
    }


}


