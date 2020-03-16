package com.example.movies

import android.app.Activity
import android.content.Intent
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import java.util.*
import com.example.movies.Splash
import com.jakewharton.processphoenix.ProcessPhoenix
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class Login : AppCompatActivity() {

    private val MY_REQUEST_CODE: Int=7117
    lateinit var provider :List<AuthUI.IdpConfig>
    lateinit var usrName: String
    lateinit var usrID: String
    lateinit var usrImg: String
    var g=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        provider=Arrays.asList<AuthUI.IdpConfig>(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build(),
            AuthUI.IdpConfig.PhoneBuilder().build()
        )

        Options()
             Handler().postDelayed({
                 contin.setOnClickListener {
                     if(g!=0) {
                         val i = Intent(this, MainActivity::class.java)
                         finish()
                         startActivity(i)
                     }
                 }

             },1500)


        logoutBtn1.setOnClickListener {


                val builder = AlertDialog.Builder(this)
                builder.setTitle("Logout")
                    .setMessage("Are you sure you want to logout?")
                    .setIcon(R.drawable.ic_logout1)
                    .setPositiveButton("Yes") { dialog, which ->

                        AuthUI.getInstance().signOut(this@Login)
                            .addOnCompleteListener {
                                logoutBtn1.isEnabled=false
                                Options()
                            }
                            .addOnFailureListener {
                               e-> Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()

                            }
                    }
                    .setNegativeButton("No", null)
                    .setNeutralButton("Cancel") { dialog, which ->
                        Toast.makeText(this, "You clicked Cancel", Toast.LENGTH_SHORT).show()
                    }
                val dialog: AlertDialog=builder.create()
                dialog.show()
            }


        }






    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==MY_REQUEST_CODE)
        {
            val response = IdpResponse.fromResultIntent(data)
            if(resultCode==Activity.RESULT_OK)
            {
                val user=FirebaseAuth.getInstance().currentUser
                Toast.makeText(this,""+user!!.email,Toast.LENGTH_SHORT).show()
                usernameText.text=user.displayName
                Picasso.with(this).load(user.photoUrl).into(imageUser)

                logoutBtn1.isEnabled=true

            }
            else{
                Toast.makeText(this,""+response!!.error!!.message,Toast.LENGTH_SHORT).show()
                logoutBtn1.isEnabled=false
                imageUser.setImageResource(R.drawable.error)
                usernameText.text=getString(R.string.error)
                contin.visibility= View.GONE
                restart.visibility=View.VISIBLE

                restart.setOnClickListener {
                    ProcessPhoenix.triggerRebirth(this)
                }
                g=0
            }
        }
    }

    private fun Options(){
        startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder()
            .setAvailableProviders(provider)
            .setTheme(R.style.MyTheme)
            .build(),MY_REQUEST_CODE)
    }


}
