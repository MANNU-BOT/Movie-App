package com.example.movies

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.fragment_downloads.*
import org.json.JSONException

@Suppress("DEPRECATION")
class DownloadsFragment : Fragment() {


    lateinit var id: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_downloads, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        search()
        ResultCard.setOnClickListener {
            val i = Intent(requireContext(), movie::class.java)
            i.putExtra("mov", id)
            startActivity(i)
        }

    }

    private fun search() {

        searchButtonMain.setOnClickListener {

            recycler.setHasFixedSize(true)
            recycler.layoutManager = LinearLayoutManager(requireContext())
            var eadap: ExampleAdapter
            val elist = arrayListOf<ExampleItem>()
            val s: String = searchTitle.text.toString()
            val y: String = searchYear.text.toString()
            val queue = Volley.newRequestQueue(requireContext())
            val omdb = "https://www.omdbapi.com/?apikey=43bddbb&s=$s&y=$y"


            val json = JsonObjectRequest(
                Request.Method.GET,
                omdb,
                null,
                Response.Listener { response ->

                    val JsonAr = response.getJSONArray("Search")
                    try {

                        for (i in 0 until JsonAr.length() step 1) {
                            val j = JsonAr.getJSONObject(i)

                            val a = j.getString("Title")
                            val b = "Year:-" + j.getString("Year")
                            id = j.getString("imdbID")
                            val e = j.getString("Poster")


                            elist.add(ExampleItem(a, b, e))
                        }
                        eadap = ExampleAdapter(requireContext(), elist)
                        recycler.adapter = eadap
                    } catch (e: JSONException) {
                        e.printStackTrace()
                        recycler.visibility = View.GONE
                        Toast.makeText(requireContext(), "Cannot Find", Toast.LENGTH_SHORT).show()
                    }

                },
                Response.ErrorListener {
                    recycler.visibility = View.GONE
                    Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                })
            queue.add(json)


        }
    }
}

/* @SuppressLint("SetTextI18n")
 fun search() {
     searchButtonMain.setOnClickListener {

         val s: String = searchTitle.text.toString()
         val y: String = searchYear.text.toString()
         val queue = Volley.newRequestQueue(requireContext())
         val omdb = "https://www.omdbapi.com/?apikey=43bddbb&t=$s&y=$y"


         val stringRequest = StringRequest(
             Request.Method.GET, omdb,
             Response.Listener<String> { response ->

                 try {
                     val j = JSONObject(response)
                     ResultCard.visibility = View.VISIBLE
                     iT1.text = j.getString("Title")
                     iT2.text = j.getString("Genre")
                     iT3.text = j.getString("Released")
                     iT4.text = j.getString("Plot")
                     id = j.getString("imdbID")
                     val s = j.getString("Poster")
                     Picasso.with(requireContext()).load(s).into(iS)
                 } catch (e: JSONException) {
                     e.printStackTrace()
                     ResultCard.visibility = View.GONE
                    Toast.makeText(requireContext(),"Cannot Find",Toast.LENGTH_SHORT).show()
                 }
             },
             Response.ErrorListener { iT1.text = "That didn't work!"
                 ResultCard.visibility = View.GONE
                 Toast.makeText(requireContext(),"No result",Toast.LENGTH_SHORT).show()})

         queue.add(stringRequest)


     }
 }*/

/*@SuppressLint("SetTextI18n")
public fun search(){
     searchButtonMain.setOnClickListener {
         val x=searchTitle.text.toString()
         val y=searchYear.text.toString()

         if(x.isEmpty()){
             searchTitle.setError("Please provide movie name")
             return@setOnClickListener
         }

         val url ="http://www.omdbapi.com/?apikey=43bddbb&t=${x}"
         val url2="http://www.omdbapi.com/?apikey=43bddbb&t=${x}&y=${y}"
         val queue:RequestQueue=Volley.newRequestQueue(activity)

         val stringRequest = StringRequest(Request.Method.GET, url,
             Response.Listener<String> {response ->
                 textView.text = "Response is: ${response.substring(0, 500)}"
             },
             Response.ErrorListener { textView.text = "That didn't work!" })
         queue.add(stringRequest)
         templet.visibility=View.VISIBLE
     }

 }//search ends*/



