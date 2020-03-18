package com.example.movies

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.os.StatFs
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.fragment_downloads.*

@Suppress("DEPRECATION")
class DownloadsFragment : Fragment() {

      var ar= arrayOf("movie","series","episode")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        search()
        return inflater.inflate(R.layout.fragment_downloads, container, false)
    }

   @SuppressLint("SetTextI18n")
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

    }//search ends


}
