package com.example.movies

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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

        DisplayTopRated()
    }

    private fun DisplayTopRated() {
        val i=Intent(requireContext(),movie::class.java)
        lcard1.setOnClickListener {
            i.putExtra("mov","tt0111161")
            startActivity(i)
        }
        lcard2.setOnClickListener {
            i.putExtra("mov","tt0068646")
            startActivity(i)
        }
        lcard3.setOnClickListener {
            i.putExtra("mov","tt0071562")
            startActivity(i)
        }
        lcard4.setOnClickListener {
            i.putExtra("mov","tt0468569")
            startActivity(i)
        }
        lcard5.setOnClickListener {
            i.putExtra("mov","tt0050083")
            startActivity(i)
        }
        lcard6.setOnClickListener {
            i.putExtra("mov","tt0108052")
            startActivity(i)
        }
        lcard7.setOnClickListener {
            i.putExtra("mov","tt0167260")
            startActivity(i)
        }
        lcard8.setOnClickListener {
            i.putExtra("mov","tt0110912")
            startActivity(i)
        }
        lcard9.setOnClickListener {
            i.putExtra("mov","tt0060196")
            startActivity(i)
        }
        lcard10.setOnClickListener {
            i.putExtra("mov","tt0120737")
            startActivity(i)
        }
    }

}
