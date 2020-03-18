package com.example.movies

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.StatFs
import android.view.Gravity
import android.view.Menu
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.header.*


@Suppress("DEPRECATION")
open class MainActivity : AppCompatActivity() {
    //objects for fragments
    lateinit var homefragment: HomeFragment
    lateinit var favFragment: FavFragment
    lateinit var latestFragment: LatestFragment
    lateinit var topRatedFragment: TopRatedFragment
    lateinit var downloadsFragment: DownloadsFragment
    var x: String? = "zero"
    var y:String?= "zero"

    @SuppressLint("WrongConstant")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bun = intent.extras

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
            Color.parseColor("#ff0b445c")                                             //changes color of status bar
        BottomNav.setBackgroundResource(R.drawable.navbar1)                           //changes background of NavigationBar


        homefragment =
            HomeFragment()                                                             //To show default fragment when app starts
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.FrameLB, homefragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()


        BottomNav.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.homeB -> {
                    x = "one"
                    drawer.setBackgroundResource(R.drawable.backimg)
                    headerLayout.setBackgroundResource(R.color.frag1)
                    window.statusBarColor =
                        Color.parseColor("#ff0b445c")                                  //changes color of status bar
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
                    x = "two"
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

                    x = "three"
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

                    x = "four"
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

                    x = "five"
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
                    y="one"
                    val i =Intent(this,Grid::class.java)
                    i.putExtra("key",y)
                    startActivity(i)
                }
                R.id.comdeyD -> {
                    y="two"
                    val i =Intent(this,Grid::class.java)
                    i.putExtra("key",y)
                    startActivity(i)
                }
                R.id.horrorD -> {
                    y="three"
                    val i =Intent(this,Grid::class.java)
                    i.putExtra("key",y)
                    startActivity(i)
                }
                R.id.animatedD -> {
                    y="four"
                    val i =Intent(this,Grid::class.java)
                    i.putExtra("key",y)
                    startActivity(i)
                }
                R.id.animeD -> {
                    y="five"
                    val i =Intent(this,Grid::class.java)
                    i.putExtra("key",y)
                    startActivity(i)
                }
                R.id.hollywoodD -> {
                    Toast.makeText(this, "clicked", Toast.LENGTH_LONG).show()
                }
                R.id.kidsD -> {
                    Toast.makeText(this, "clicked", Toast.LENGTH_LONG).show()
                }
                R.id.aboutD -> {
                val a = Intent(this, About::class.java)
                a.putExtra("key", x)
                startActivity(a)
            }                        //Opens About Section
                R.id.feedbackD -> {
                    Toast.makeText(this, "will be active is ever reached Playstore", Toast.LENGTH_LONG)
                        .show()
                }                     //will take to playstore
                R.id.reportD -> {
                    val b = Intent(this, Bugs::class.java)
                    b.putExtra("key", x)
                    startActivity(b)
                }                       //Will open report page
                R.id.helpD -> {
                    Toast.makeText(this, "Not completed yet", Toast.LENGTH_LONG).show()
                    val browser = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://docs.google.com/document/d/1RxtQIeNgvY7JYWYifQeisowrTZfy069GGf_vQ1uSKJc/edit?usp=sharing")
                    )
                    startActivity(browser)

                }                         //Will open a google documentation
                R.id.logoutD -> {

                    val warn = AlertDialog.Builder(this)
                    warn.setTitle("Logout")
                        .setMessage("Are you sure you want to logout?")
                        .setIcon(R.drawable.ic_logout1)
                        .setPositiveButton("Yes") { dialog, which ->
                            val l = Intent(this, Login::class.java)
                            startActivity(l)

                        }.setNeutralButton("No") { dialog, which ->
                            Toast.makeText(this, "You clicked Cancel", Toast.LENGTH_SHORT).show()
                        }
                    val dialog: AlertDialog = warn.create()
                    dialog.show()
                }                       //Logout to and takes to Login Page
            }
            drawerLay.layoutDirection = Gravity.START

            true

        }

        mainBar.setOnMenuItemClickListener { item ->

            when (item.itemId) {
                R.id.closeT -> {

                    val warn = AlertDialog.Builder(this)
                    warn.setTitle("Exit")
                        .setMessage("Do you want to exit?")
                        .setIcon(R.drawable.ic_exitdark)
                        .setPositiveButton("Yes") { dialog, which ->
                         finishAffinity()
                        }.setNeutralButton("No", null)
                    val dialog: AlertDialog = warn.create()
                    dialog.show()
                }
                else -> {
                    Toast.makeText(this, "Adding Soon", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.toolbarmenu, menu)
        return true
    }


}