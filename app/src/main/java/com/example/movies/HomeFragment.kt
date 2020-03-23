package com.example.movies

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_home.*

@Suppress("UNREACHABLE_CODE")
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       AllButtons()
    }



    fun AllButtons(){
        block1.setOnClickListener {
            val i = Intent(requireContext(), SampleMovies::class.java)
            i.putExtra("key", "one")
            startActivity(i)
        }
        block2.setOnClickListener {
            val i = Intent(requireContext(), SampleMovies::class.java)
            i.putExtra("key", "three")
            startActivity(i)
        }
        block3.setOnClickListener {
            val i = Intent(requireContext(), SampleMovies::class.java)
            i.putExtra("key", "two")
            startActivity(i)
        }
        block4.setOnClickListener {
            val i = Intent(requireContext(), SampleMovies::class.java)
            i.putExtra("key", "five")
            startActivity(i)
        }
        block5.setOnClickListener {
            val i = Intent(requireContext(), SampleMovies::class.java)
            i.putExtra("key", "four")
            startActivity(i)
        }
        block6.setOnClickListener {
            val i= Toast.makeText(requireContext(),"Not Available",Toast.LENGTH_SHORT)
            i.setGravity(Gravity.CENTER,0,0)
            i.show()
        }

        rollMovies()

    }

    private fun rollMovies() {
        val i=Intent(requireContext(),movie::class.java)
        box1.setOnClickListener {
            i.putExtra("mov","tt0448115")
            startActivity(i)
        }
        box2.setOnClickListener {
            i.putExtra("mov","tt4849438")
            startActivity(i)
        }
        box3.setOnClickListener {
            i.putExtra("mov","tt8366590")
            startActivity(i)
        }
    }

}


