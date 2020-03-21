package com.example.movies

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.bugs.*

class Bugs : AppCompatActivity() {

    @SuppressLint("ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bugs)

        val bun = intent.extras
        val id = bun!!.getString("id")

        when (bun.getString("key")) {
            "one" -> bugsLayout.setBackgroundResource(R.drawable.backimg)
            "two" -> bugsLayout.setBackgroundResource(R.drawable.backlatest)
            "three" -> bugsLayout.setBackgroundResource(R.drawable.backfav)
            "four" -> bugsLayout.setBackgroundResource(R.drawable.backtoprated)
            "five" -> bugsLayout.setBackgroundResource(R.drawable.backdown)
            else -> bugsLayout.setBackgroundResource(R.drawable.backimg)
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

        buttonB.setOnClickListener {

            val recipient = "manu227gkp@gmail.com"
            val subject = subjectB.text.toString().trim()
            val message = messageB.text.toString().trim()
            sendEmail(recipient, subject, message, id)

            val v: View? = this.currentFocus
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(v!!.windowToken, 0)
        }

    }

    private fun sendEmail(recipient: String, subject: String, message: String, id: String?) {

        val mailI = Intent(Intent.ACTION_SEND)
        mailI.data = Uri.parse("mailto:")
        mailI.type = "text/plain"
        mailI.putExtra(Intent.EXTRA_CC, id)
        mailI.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        mailI.putExtra(Intent.EXTRA_SUBJECT, subject)
        mailI.putExtra(Intent.EXTRA_TEXT, message)
        mailI.setPackage("com.google.android.gm")

        try {
            startActivity(Intent.createChooser(mailI, "Send Mail"))
        } catch (e: Exception) {
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }
    }

}
