package com.example.movies

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.firebase.ui.auth.AuthUI
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.header.*
import com.example.movies.Login
import kotlinx.android.synthetic.main.about.*
import kotlinx.android.synthetic.main.activity_login.*


@Suppress("DEPRECATION")
open class MainActivity : AppCompatActivity() {
    //objects for fragments
    lateinit var homefragment: HomeFragment
    lateinit var favFragment: FavFragment
    lateinit var latestFragment: LatestFragment
    lateinit var topRatedFragment: TopRatedFragment
    lateinit var downloadsFragment: DownloadsFragment

    @SuppressLint("WrongConstant")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(mainBar)                                                  //setting the toolbar
        drawerLay.layoutDirection = Gravity.START

        val toggle = ActionBarDrawerToggle(
            this, drawerLay, mainBar, 0, 0
        )
        drawerLay.addDrawerListener(toggle)
        toggle.syncState()

        //initial state
        supportActionBar?.setDisplayHomeAsUpEnabled(true)                             //Adds a back button
        supportActionBar?.setHomeAsUpIndicator(R.drawable.drawer)                     //Displaying drawer icon for homePage
        window.statusBarColor =
            Color.parseColor("#ff0b445c")                         //changes color of status bar
        BottomNav.setBackgroundResource(R.drawable.navbar1)                           //changes background of NavigationBar


        homefragment =
            HomeFragment()                                                 //To show default fragment when app starts
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.FrameLB, homefragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()


        BottomNav.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.homeB -> {

                    drawer.setBackgroundResource(R.drawable.backimg)
                    headerLayout.setBackgroundResource(R.color.frag1)
                    window.statusBarColor =
                        Color.parseColor("#ff0b445c")              //changes color of status bar
                    BottomNav.setBackgroundResource(R.drawable.navbar1)                //changes background of NavigationBar
                    mainAppbar.setBackgroundResource(R.drawable.navbar1)               //changes AppBar Background
                    homefragment = HomeFragment()
                    supportFragmentManager
                        .beginTransaction()                                            //shows Home fragment
                        .replace(R.id.FrameLB, homefragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }

                R.id.latestB -> {

                    aboutLayout.setBackgroundResource()
                    drawer.setBackgroundResource(R.drawable.backlatest)
                    headerLayout.setBackgroundResource(R.color.frag2)
                    window.statusBarColor =
                        Color.parseColor("#ff1b4641")              //changes color of status bar
                    BottomNav.setBackgroundResource(R.drawable.navbar2)                //changes background of NavigationBar
                    mainAppbar.setBackgroundResource(R.drawable.navbar2)               //changes AppBar Background
                    latestFragment = LatestFragment()
                    supportFragmentManager
                        .beginTransaction()                                            //shows Latest fragment
                        .replace(R.id.FrameLB, latestFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.favoritesB -> {

                    drawer.setBackgroundResource(R.drawable.backfav)
                    headerLayout.setBackgroundResource(R.color.frag3)
                    window.statusBarColor =
                        Color.parseColor("#ff1f91cc")             //changes color of status bar
                    BottomNav.setBackgroundResource(R.drawable.navbar3)               //changes background of NavigationBar
                    mainAppbar.setBackgroundResource(R.drawable.navbar3)               //changes AppBar Background

                    favFragment = FavFragment()
                    supportFragmentManager
                        .beginTransaction()                                           //shows fav fragment
                        .replace(R.id.FrameLB, favFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.topratedB -> {

                    drawer.setBackgroundResource(R.drawable.backtoprated)
                    headerLayout.setBackgroundResource(R.color.frag4)
                    window.statusBarColor =
                        Color.parseColor("#ff024da1")            //changes color of status bar
                    BottomNav.setBackgroundResource(R.drawable.navbar4)              //changes background of NavigationBar
                    mainAppbar.setBackgroundResource(R.drawable.navbar4)               //changes AppBar Background

                    topRatedFragment = TopRatedFragment()
                    supportFragmentManager
                        .beginTransaction()                                          //shows topRated fragment
                        .replace(R.id.FrameLB, topRatedFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.downloadsB -> {

                    drawer.setBackgroundResource(R.drawable.backdown)
                    headerLayout.setBackgroundResource(R.color.frag5)
                    window.statusBarColor =
                        Color.parseColor("#ff444849")            //changes color of status bar
                    BottomNav.setBackgroundResource(R.drawable.navbar5)              //changes background of NavigationBar
                    mainAppbar.setBackgroundResource(R.drawable.navbar5)               //changes AppBar Background


                    downloadsFragment = DownloadsFragment()
                    supportFragmentManager
                        .beginTransaction()                                          //shows downloads fragment
                        .replace(R.id.FrameLB, downloadsFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }
            true
        }


        drawer.setNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.actionD -> {
                    Toast.makeText(this, "clicked", Toast.LENGTH_LONG).show()
                }
                R.id.comdeyD -> {
                    Toast.makeText(this, "clicked", Toast.LENGTH_LONG).show()
                }
                R.id.horrorD -> {
                    Toast.makeText(this, "clicked", Toast.LENGTH_LONG).show()
                }
                R.id.animatedD -> {
                    Toast.makeText(this, "clicked", Toast.LENGTH_LONG).show()
                }
                R.id.animeD -> {
                    Toast.makeText(this, "clicked", Toast.LENGTH_LONG).show()
                }
                R.id.hollywoodD -> {
                    Toast.makeText(this, "clicked", Toast.LENGTH_LONG).show()
                }
                R.id.kidsD -> {
                    Toast.makeText(this, "clicked", Toast.LENGTH_LONG).show()
                }
                R.id.aboutD -> {
                    val a = Intent(this, About::class.java)
                    startActivity(a)
                }
                R.id.feedbackD -> {
                    Toast.makeText(this, "Active when app reaches Playstore", Toast.LENGTH_LONG).show()
                }
                R.id.reportD -> {
                    val b = Intent(this, Bugs::class.java)
                    startActivity(b)
                }
                R.id.helpD -> {
                    Toast.makeText(this, "clicked", Toast.LENGTH_LONG).show()
                }
                R.id.logoutD -> {

                    val warn = AlertDialog.Builder(this)
                    warn.setTitle("Logout")
                        .setMessage("Are you sure you want to logout?")
                        .setIcon(R.drawable.ic_logout1)
                        .setPositiveButton("Yes") { dialog,which->
                            val l=Intent(this,Login::class.java)
                            startActivity(l)

                        }.setNegativeButton("No", null)
                        .setNeutralButton("Cancel") { dialog, which ->
                            Toast.makeText(this, "You clicked Cancel", Toast.LENGTH_SHORT).show()
                        }
                    val dialog: AlertDialog = warn.create()
                    dialog.show()
                }
            }
            drawerLay.layoutDirection = Gravity.START

            true

        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.toolbarmenu, menu)
        return true
    }


}