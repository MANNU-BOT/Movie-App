package com.example.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    //objects for fragments
    lateinit var homefragment: HomeFragment
    lateinit var favFragment: FavFragment
    lateinit var latestFragment: LatestFragment
    lateinit var topRatedFragment: TopRatedFragment
    lateinit var downloadsFragment: DownloadsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        homefragment = HomeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.FrameLB, homefragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()


        BottomNav.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.homeB -> {
                    homefragment = HomeFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.FrameLB, homefragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.latestB -> {
                    latestFragment = LatestFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.FrameLB, latestFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.favoritesB -> {
                    favFragment = FavFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.FrameLB, favFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.topratedB -> {
                    topRatedFragment = TopRatedFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.FrameLB, topRatedFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.downloadsB -> {
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