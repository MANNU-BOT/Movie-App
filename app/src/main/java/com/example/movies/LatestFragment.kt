package com.example.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_latest.*
import android.os.Bundle as Bundle1


class LatestFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle1?
    ): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_latest, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: android.os.Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Picasso.with(requireContext()).load("https://m.media-amazon.com/images/M/MV5BMTlkMmVmYjktYTc2NC00ZGZjLWEyOWUtMjc2MDMwMjQwOTA5XkEyXkFqcGdeQXVyNTI4MzE4MDU@._V1_SX300.jpg").into(listimage7)
        Picasso.with(requireContext()).load("https://m.media-amazon.com/images/M/MV5BMTZlYzk3NzQtMmViYS00YWZmLTk5ZTEtNWE0NGVjM2MzYWU1XkEyXkFqcGdeQXVyNDg4NjY5OTQ@._V1_SX300.jpg").into(listimage5)
        Picasso.with(requireContext()).load("https://m.media-amazon.com/images/M/MV5BMWU0MGYwZWQtMzcwYS00NWVhLTlkZTAtYWVjOTYwZTBhZTBiXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_SX300.jpg").into(listimage2)

        DisplayLatest()
    }

    private fun DisplayLatest() {
        val i = Intent(requireContext(), movie::class.java)
        card1.setOnClickListener {
            i.putExtra("mov", "tt8366590")
            val warn = AlertDialog.Builder(requireContext())
            warn.setTitle("Warning")
                .setMessage("Do you want to have CANCER?")
                .setIcon(R.drawable.ic_warning)
                .setPositiveButton("Yes") { dialog, which ->
                    startActivity(i)
                }.setNeutralButton("No", null)
            val dialog: AlertDialog = warn.create()
            dialog.show()
        }
        card2.setOnClickListener {
            i.putExtra("mov", "tt1502397")
            startActivity(i)
        }
        card3.setOnClickListener {
            i.putExtra("mov", "tt1634106")
            startActivity(i)
        }
        card4.setOnClickListener {
            i.putExtra("mov", "tt4566758")
            startActivity(i)
        }
        card5.setOnClickListener {
            i.putExtra("mov", "tt7146812")
            startActivity(i)
        }
        card6.setOnClickListener {
            i.putExtra("mov", "tt7713068")
            startActivity(i)
        }
        card7.setOnClickListener {
            i.putExtra("mov", "tt8367814")
            startActivity(i)
        }

    }
}
