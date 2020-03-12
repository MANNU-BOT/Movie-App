package com.example.movies
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    //objects for fragments
    lateinit var homefragment: HomeFragment
    lateinit var favFragment: FavFragment
    lateinit var latestFragment: LatestFragment
    lateinit var topRatedFragment: TopRatedFragment
    lateinit var downloadsFragment: DownloadsFragment

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.statusBarColor = Color.parseColor("#ff0b445c")
        BottomNav.setBackgroundResource(R.color.frag1)


        homefragment = HomeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.FrameLB, homefragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()


        BottomNav.setOnNavigationItemSelectedListener {
                item ->

            when (item.itemId) {
                R.id.homeB -> {

                    window.statusBarColor = Color.parseColor("#ff0b445c")
                    BottomNav.setBackgroundResource(R.color.frag1)
                    homefragment = HomeFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.FrameLB, homefragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.latestB -> {

                    window.statusBarColor = Color.parseColor("#ff1b4641")
                    BottomNav.setBackgroundResource(R.color.frag2)
                    latestFragment = LatestFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.FrameLB, latestFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.favoritesB -> {

                    window.statusBarColor = Color.parseColor("#ff1f91cc")
                    BottomNav.setBackgroundResource(R.color.frag3)
                    favFragment = FavFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.FrameLB, favFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.topratedB -> {

                    window.statusBarColor = Color.parseColor("#ff024da1")
                    BottomNav.setBackgroundResource(R.color.frag4)
                    topRatedFragment = TopRatedFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.FrameLB, topRatedFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.downloadsB -> {

                    window.statusBarColor = Color.parseColor("#ff444849")
                    BottomNav.setBackgroundResource(R.color.frag5)

                    downloadsFragment = DownloadsFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.FrameLB, downloadsFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }
            true
        }


    }
}