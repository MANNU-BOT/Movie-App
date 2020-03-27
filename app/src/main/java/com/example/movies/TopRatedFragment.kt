package com.example.movies

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_top_rated.*

class TopRatedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_top_rated, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Picasso.with(requireContext())
            .load("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg")
            .into(lcard1)
        Picasso.with(requireContext())
            .load("https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg")
            .into(lcard2)
        Picasso.with(requireContext())
            .load("https://m.media-amazon.com/images/M/MV5BMWMwMGQzZTItY2JlNC00OWZiLWIyMDctNDk2ZDQ2YjRjMWQ0XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg")
            .into(lcard3)
        Picasso.with(requireContext())
            .load("https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_SX300.jpg")
            .into(lcard4)
        Picasso.with(requireContext())
            .load("https://m.media-amazon.com/images/M/MV5BMWU4N2FjNzYtNTVkNC00NzQ0LTg0MjAtYTJlMjFhNGUxZDFmXkEyXkFqcGdeQXVyNjc1NTYyMjg@._V1_SX300.jpg")
            .into(lcard5)
        Picasso.with(requireContext())
            .load("https://m.media-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg")
            .into(lcard6)
        Picasso.with(requireContext())
            .load("https://m.media-amazon.com/images/M/MV5BNzA5ZDNlZWMtM2NhNS00NDJjLTk4NDItYTRmY2EwMWZlMTY3XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg")
            .into(lcard7)
        Picasso.with(requireContext())
            .load("https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg")
            .into(lcard8)
        Picasso.with(requireContext())
            .load("https://m.media-amazon.com/images/M/MV5BOTQ5NDI3MTI4MF5BMl5BanBnXkFtZTgwNDQ4ODE5MDE@._V1_SX300.jpg")
            .into(lcard9)
        Picasso.with(requireContext())
            .load("https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_SX300.jpg")
            .into(lcard10)

        DisplayTopRated()
    }

    private fun DisplayTopRated() {
        val i = Intent(requireContext(), movie::class.java)
        lcard1.setOnClickListener {
            i.putExtra("mov", "tt0111161")
            startActivity(i)
        }
        lcard2.setOnClickListener {
            i.putExtra("mov", "tt0068646")
            startActivity(i)
        }
        lcard3.setOnClickListener {
            i.putExtra("mov", "tt0071562")
            startActivity(i)
        }
        lcard4.setOnClickListener {
            i.putExtra("mov", "tt0468569")
            startActivity(i)
        }
        lcard5.setOnClickListener {
            i.putExtra("mov", "tt0050083")
            startActivity(i)
        }
        lcard6.setOnClickListener {
            i.putExtra("mov", "tt0108052")
            startActivity(i)
        }
        lcard7.setOnClickListener {
            i.putExtra("mov", "tt0167260")
            startActivity(i)
        }
        lcard8.setOnClickListener {
            i.putExtra("mov", "tt0110912")
            startActivity(i)
        }
        lcard9.setOnClickListener {
            i.putExtra("mov", "tt0060196")
            startActivity(i)
        }
        lcard10.setOnClickListener {
            i.putExtra("mov", "tt0120737")
            startActivity(i)
        }
    }

}
