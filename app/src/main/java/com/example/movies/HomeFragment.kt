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
/*Because not every movie id gives a recommendation,only few of them can so I end up doing somthing like this,Which is something between static and dyanamic*/
    val heading = arrayOf(
        "Superheros-",//1
        "Superheros-",//2
        "Horror-",//3
        "Science Fiction-",//4
        " Comedy,Adventure-",//5
        "Superheros-",//6
        "Action-",//7
        "English-",//8
        "Action-",//9
        "Harry Potter-",//10
        "Superheros-",//11
        "French-",//12
        "Science Fiction-",//13
        "English-",//14
        "Anime-",//15
        "Action, Adventure-",//16
        "Horror-",//17
        "Comedy-",//18
        "Adventure-",//19
        "Adventure, Thrill-",//20
        "Animals-",//21
        "Fantasy-",//22
        "Adventure, Fantasy-",//23
        "Thriller, Comedy-",//24
        "Science Fiction-",//25
        "Anime-",//26
        "Dragon Ball-",//27
        "Naruto-",//28
        "Anime-",//29
        "Action, Thriller-",//30
        "Bollywood Hits-",//31
        "Bollywood Hits-",//32
        "Bollywood-",//33
        "Action, Thriller-",//34
        "Malayalam-",//35
        "Telgu-",//36
        "Bollywood Horror, Romance-",//37
        "Animated Hits-",//38
        "Animated-",//39
        "Kids-",//40
        "Sinchan: The Legend-",//41
        "Doraemon-",//42
        "Action,Fighting-",//43
        "Science Fiction-",//44
        "English-",//45
        "Shahrukh-"//46
    )

    val recomID = arrayOf(
        1924,//1
        268,//2
        619264,//3
        348350,//4
        353486,//5
        299534,//6
        87101,//7
        39538,//8
        245891,//9
        672,//10
        268,//11
        1622,//12
        85949,//13
        85949,//14
        372058,//15
        20662,//16
        6114,//17
        448119,//18
        329,//19
        331,//20
        10992,//21
        8966,//22
        58,//23
        161436,//24
        105,//25
        372058,//26
        39148,//27
        347201,//28
        426285,//29
        391629,//30
        297222,//31
        348892,//32
        465642,//33
        350312,//34
        459719,//35
        148265,//36
        363335,//37
        109445,//38
        920,//39
        136799,//40
        89458,//41
        265712,//42
        550,//43
        157336,//44
        371645,//45
        19404//46
    )

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

        val r = (0..45).random()
        t1.text = heading[r]
        val url =
            "https://api.themoviedb.org/3/movie/${recomID[r]}/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
        parseJSON(url, recycler1)
    }

    private fun Recycler2() {

        val r = (0..45).random()
        t2.text = heading[r]
        val url =
            "https://api.themoviedb.org/3/movie/${recomID[r]}/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
        parseJSON(url, recycler2)

    }

    private fun Recycler3() {
        val r = (0..45).random()
        t3.text = heading[r]
        val url =
            "https://api.themoviedb.org/3/movie/${recomID[r]}/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
        parseJSON(url, recycler3)
    }

    private fun Recycler4() {
        val r = (0..45).random()
        t4.text = heading[r]
        val url =
            "https://api.themoviedb.org/3/movie/${recomID[r]}/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
        parseJSON(url, recycler4)
    }

    private fun Recycler5() {
        val r = (0..45).random()
        t5.text = heading[r]
        val url =
            "https://api.themoviedb.org/3/movie/${recomID[r]}/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
        parseJSON(url, recycler5)
    }

    private fun Recycler6() {
        val r = (0..45).random()
        t6.text = heading[r]
        val url =
            "https://api.themoviedb.org/3/movie/${recomID[r]}/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
        parseJSON(url, recycler6)
    }

    private fun Recycler7() {
        val r = (0..45).random()
        t7.text = heading[r]
        val url =
            "https://api.themoviedb.org/3/movie/${recomID[r]}/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
        parseJSON(url, recycler7)
    }

    private fun Recycler8() {
        val r = (0..45).random()
        t8.text = heading[r]
        val url =
            "https://api.themoviedb.org/3/movie/${recomID[r]}/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
        parseJSON(url, recycler8)
    }

    private fun Recycler9() {
        val r = (0..45).random()
        t9.text = heading[r]
        val url =
            "https://api.themoviedb.org/3/movie/${recomID[r]}/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
        parseJSON(url, recycler9)
    }

    private fun Recycler10() {
        val r = (0..45).random()
        t10.text = heading[r]
        val url =
            "https://api.themoviedb.org/3/movie/${recomID[r]}/recommendations?api_key=ac2a4cc7c14f6ec89fdc0fbe992b48e2"
        parseJSON(url, recycler10)
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


