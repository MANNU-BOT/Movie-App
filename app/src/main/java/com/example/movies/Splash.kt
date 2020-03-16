package com.example.movies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.os.StatFs
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import kotlinx.android.synthetic.main.activity_splash.*
import java.io.File

class Splash : AppCompatActivity() {
    lateinit var h: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        val a =AlphaAnimation(0.0f,1.0f)
        a.duration=3000
        a.startOffset=100
        a.repeatCount=1
        imageS.startAnimation(a)

        h= Handler()
        h.postDelayed({

            val intent = Intent(this,Login::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}
