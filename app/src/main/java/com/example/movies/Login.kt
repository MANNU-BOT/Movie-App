package com.example.movies

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    lateinit var usrName: String
    lateinit var usrID: String
    lateinit var usrImg: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        SignUpButton.setOnClickListener {
            startActivity(Intent(this, Register::class.java))
        }

        LoginButton.setOnClickListener {
            LoginMe()
            val v: View? = this.currentFocus
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(v!!.windowToken, 0)
        }

    }

    private fun LoginMe() {

        if (EmailLogin.text.toString().isEmpty()) {
            EmailLogin.error = "Enter Email-id"
            EmailLogin.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(EmailLogin.text.toString()).matches()) {
            EmailLogin.error = "Enter valid Email-id"
        }
        if (passwordLogin.text.toString().isEmpty()) {
            passwordLogin.error = "Enter password"
            passwordLogin.requestFocus()
            return
        }

        auth.signInWithEmailAndPassword(EmailLogin.text.toString(), passwordLogin.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    updateUI(null)
                }
            }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun updateUI(currentUser: FirebaseUser?) {

        if (currentUser != null) {
            if (currentUser.isEmailVerified) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(
                    baseContext, "Verify your email",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else {
            Toast.makeText(
                baseContext, "Login Failed",
                Toast.LENGTH_SHORT
            ).show()

        }

    }
}



