package com.example.movies

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.movie.*

class movie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie)

        heart.setOnAnimationEndListener {
            Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show()
        }
    }
}
