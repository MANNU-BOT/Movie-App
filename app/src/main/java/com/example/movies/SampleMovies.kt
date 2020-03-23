//NOT WORKING


package com.example.movies

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_sample_movies.*


@Suppress("DEPRECATION")
class SampleMovies : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_movies)

        val bun = intent.extras

        when (bun!!.getString("key")) {

            "one" -> {
                actionGrid.visibility = View.VISIBLE
                categoryName.text = "ACTION"
            }
            "two" -> {
                comedyGrid.visibility = View.VISIBLE
                categoryName.text = "COMEDY"
            }
            "three" -> {
                HorrorGrid.visibility = View.VISIBLE
                categoryName.text = "HORROR"
            }
            "four" -> {
                animGrid.visibility = View.VISIBLE
                categoryName.text = "ANIMATED"
            }
            "five" -> {
                animeGrid.visibility = View.VISIBLE
                categoryName.text = "ANIME"
            }
            else -> {
                animeGrid.visibility = View.VISIBLE
                categoryName.text = "ERROR"
            }
        }


        AnimDisplay()
        HorrorDisplay()
        AnimeDisplay()
        ActionDisplay()
        ComedyDisplay()
    }
    private fun ComedyDisplay() {
        val i = Intent(this, movie::class.java)
        c1.setOnClickListener {
            i.putExtra("mov", "tt8629748")
            startActivity(i)
        }
        c2.setOnClickListener {
            i.putExtra("mov", "tt8946378")
            startActivity(i)
        }
        c3.setOnClickListener {
            i.putExtra("mov", "tt0898266")
            startActivity(i)
        }
        c4.setOnClickListener {
            i.putExtra("mov", "tt6751668")
            startActivity(i)
        }
        c5.setOnClickListener {
            i.putExtra("mov", "tt3794354")
            startActivity(i)
        }
        c6.setOnClickListener {
            i.putExtra("mov", "tt9446688")
            startActivity(i)
        }
        c7.setOnClickListener {
            i.putExtra("mov", "tt9214832")
            startActivity(i)
        }
        c8.setOnClickListener {
            i.putExtra("mov", "tt7767422")
            startActivity(i)
        }
        c9.setOnClickListener {
            i.putExtra("mov", "tt2584384")
            startActivity(i)
        }
        c10.setOnClickListener {
            i.putExtra("mov", "tt7975244")
            startActivity(i)
        }
        c11.setOnClickListener {
            i.putExtra("mov", "tt0386676")
            startActivity(i)
        }
        c12.setOnClickListener {
            i.putExtra("mov", "tt7131622")
            startActivity(i)
        }

    }

    private fun ActionDisplay() {

        val i = Intent(this, movie::class.java)
        a1.setOnClickListener {
            i.putExtra("mov", "tt8629748")
            startActivity(i)
        }
        a2.setOnClickListener {
            i.putExtra("mov", "tt0944947")
            startActivity(i)
        }
        a3.setOnClickListener {
            i.putExtra("mov", "tt6450804")
            startActivity(i)
        }
        a4.setOnClickListener {
            i.putExtra("mov", "tt2527338")
            startActivity(i)
        }
        a5.setOnClickListener {
            i.putExtra("mov", "tt0092455")
            startActivity(i)
        }
        a6.setOnClickListener {
            i.putExtra("mov", "tt2382320")
            startActivity(i)
        }
        a7.setOnClickListener {
            i.putExtra("mov", "tt4566758")
            startActivity(i)
        }
        a8.setOnClickListener {
            i.putExtra("mov", "tt8111088")
            startActivity(i)
        }
        a9.setOnClickListener {
            i.putExtra("mov", "tt3107288")
            startActivity(i)
        }
        a10.setOnClickListener {
            i.putExtra("mov", "tt3480822")
            startActivity(i)
        }
        a11.setOnClickListener {
            i.putExtra("mov", "tt8366590")
            Toast.makeText(this,"LoL",Toast.LENGTH_SHORT).show()
            startActivity(i)
        }
        a12.setOnClickListener {
            i.putExtra("mov", "tt1950186")
            startActivity(i)
        }

    }

    private fun AnimeDisplay() {
        val i =Intent(this,movie::class.java)
        an1.setOnClickListener {
            i.putExtra("mov", "tt9679542")//
            startActivity(i)
        }
        an2.setOnClickListener {
            i.putExtra("mov", "tt5323662")
            startActivity(i)
        }
        an3.setOnClickListener {
            i.putExtra("mov", "tt0988824")//
            startActivity(i)
        }
        an4.setOnClickListener {
            i.putExtra("mov", "tt0388629")
            startActivity(i)
        }
        an5.setOnClickListener {
            i.putExtra("mov", "tt5311514")
            startActivity(i)
        }
        an6.setOnClickListener {
            i.putExtra("mov", "tt2560140")
            startActivity(i)
        }
        an7.setOnClickListener {
            i.putExtra("mov", "tt4508902")
            startActivity(i)
        }
        an8.setOnClickListener {
            i.putExtra("mov", "tt1355642")
            startActivity(i)
        }
        an9.setOnClickListener {
            i.putExtra("mov", "tt0214341")
            startActivity(i)
        }
        an10.setOnClickListener {
            i.putExtra("mov", "tt0877057")
            startActivity(i)
        }
        an11.setOnClickListener {
            i.putExtra("mov", "tt9735672")
            startActivity(i)
        }
        an12.setOnClickListener {
            i.putExtra("mov", "tt8856470")
            startActivity(i)
        }
    }

    private fun HorrorDisplay() {
        val i =Intent(this,movie::class.java)
        h1.setOnClickListener {
            i.putExtra("mov", "tt10342730")
            startActivity(i)
        }
        h2.setOnClickListener {
            i.putExtra("mov", "tt0070047")
            startActivity(i)
        }
        h3.setOnClickListener {
            i.putExtra("mov", "tt0983946")
            startActivity(i)
        }
        h4.setOnClickListener {
            i.putExtra("mov", "tt4682266")
            startActivity(i)
        }
        h5.setOnClickListener {
            i.putExtra("mov", "tt3612126")
            startActivity(i)
        }
        h6.setOnClickListener {
            i.putExtra("mov", "tt3152592")
            startActivity(i)
        }
        h7.setOnClickListener {
            i.putExtra("mov", "tt6611916")
            startActivity(i)
        }
        h8.setOnClickListener {
            i.putExtra("mov", "tt8372298")
            startActivity(i)
        }
        h9.setOnClickListener {
            i.putExtra("mov", "tt8228288")
            startActivity(i)
        }
        h10.setOnClickListener {
            i.putExtra("mov", "tt5606664")
            startActivity(i)
        }
        h11.setOnClickListener {
            i.putExtra("mov", "tt2628232")
            startActivity(i)
        }
        h12.setOnClickListener {
            i.putExtra("mov", "tt5780592")
            startActivity(i)
        }
    }

    private fun AnimDisplay() {

        val i = Intent(this, movie::class.java)
        i1.setOnClickListener {
            i.putExtra("mov", "tt3521164")
            startActivity(i)
        }
        i2.setOnClickListener {
            i.putExtra("mov", "tt0182576")
            startActivity(i)
        }
        i3.setOnClickListener {
            i.putExtra("mov", "tt2948372")
            startActivity(i)
        }
        i4.setOnClickListener {
            i.putExtra("mov", "tt4520988")
            startActivity(i)
        }
        i5.setOnClickListener {
            i.putExtra("mov", "tt5814534")
            startActivity(i)
        }
        i6.setOnClickListener {
            i.putExtra("mov", "tt6105098")//
            startActivity(i)
        }
        i7.setOnClickListener {
            i.putExtra("mov", "tt1979376")
            startActivity(i)
        }
        i8.setOnClickListener {
            i.putExtra("mov", "tt3152592")
            startActivity(i)
        }
        i9.setOnClickListener {
            i.putExtra("mov", "tt1185834")//
            startActivity(i)
        }
        i10.setOnClickListener {
            i.putExtra("mov", "tt3398228")
            startActivity(i)
        }
        i11.setOnClickListener {
            i.putExtra("mov", "tt2861424")//
            startActivity(i)
        }
        i12.setOnClickListener {
            i.putExtra("mov", "tt0096697")
            startActivity(i)
        }

    }
}

