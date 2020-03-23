package com.example.movies

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_downloads.*
import org.json.JSONException
import org.json.JSONObject

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

    @SuppressLint("SetTextI18n")
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
    }
}

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



