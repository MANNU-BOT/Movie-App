package com.example.movies

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.register.*

class Register : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        auth = FirebaseAuth.getInstance()

        RegiButton.setOnClickListener {
            AllTheErrors()
            val v: View? = this.currentFocus
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(v!!.windowToken, 0)
        }

    }

    private fun AllTheErrors() {
        if (UsrnameRegi.text.toString().isEmpty()) {
            UsrnameRegi.error = "Enter Username"
            UsrnameRegi.requestFocus()
            return

        }
        if (emailRegi.text.toString().isEmpty()) {
            emailRegi.error = "Enter Email-id"
            emailRegi.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(emailRegi.text.toString()).matches()) {
            emailRegi.error = "Enter valid Email-id"
        }
        if (passwordRegi.text.toString().isEmpty()) {
            passwordRegi.error = "Enter password"
            passwordRegi.requestFocus()
            return
        }
        if (passwordRegi.text.toString().length <= 5) {
            passwordRegi.error = "Password too short"
            passwordRegi.requestFocus()
            return
        }


        auth.createUserWithEmailAndPassword(emailRegi.text.toString(), passwordRegi.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val auth = FirebaseAuth.getInstance()
                    val user = auth.currentUser

                    user?.sendEmailVerification()
                        ?.addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                val i = Intent(this, Login::class.java)
                                startActivity(i)
                                finish()
                            }
                        }
                } else {
                    Toast.makeText(
                        baseContext, "Registration Failed, Try Later",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }


    }
}
