package com.example.movies

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.about.*

class About : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about)


        val bun = intent.extras

        when (bun!!.getString("key")) {
            "one" -> aboutLayout.setBackgroundResource(R.drawable.backimg)
            "two" -> aboutLayout.setBackgroundResource(R.drawable.backlatest)
            "three" -> aboutLayout.setBackgroundResource(R.drawable.backfav)
            "four" -> aboutLayout.setBackgroundResource(R.drawable.backtoprated)
            "five" -> aboutLayout.setBackgroundResource(R.drawable.backdown)
            else -> aboutLayout.setBackgroundResource(R.drawable.backimg)
        }

        when (bun.getString("key")) {
            "one" -> {
                window.statusBarColor = Color.parseColor("#ff0b445c")
            }
            "two" -> {
                window.statusBarColor = Color.parseColor("#ff1b4641")
            }
            "three" -> {
                window.statusBarColor = Color.parseColor("#ff1f91cc")
            }
            "four" -> {
                window.statusBarColor = Color.parseColor("#ff024da1")
            }
            "five" -> {
                window.statusBarColor = Color.parseColor("#ff444849")
            }
            else -> {
                window.statusBarColor = Color.parseColor("#ff0b445c")
            }
        }

        nameA.setOnClickListener {
            val browser = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Manvendra.Is.D.Boss"))
            startActivity(browser)
        }
        instaA.setOnClickListener {
            val browser = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/manvendra966/?hl=en"))
            startActivity(browser)
        }
        twitterA.setOnClickListener {
            val browser = Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/dsckiet"))
            startActivity(browser)
        }
        youtubeA.setOnClickListener {
            val browser = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCLt6rvmptB032J3ljWTUmcQ?view_as=subscriber"))
            startActivity(browser)
        }
        linkedinA.setOnClickListener {
            val browser = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/manvendra-pratap-singh-54b2861a2/"))
            startActivity(browser)
        }
        githubA.setOnClickListener {
            val browser = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/MANNU-BOT"))
            startActivity(browser)
        }





    }
}
