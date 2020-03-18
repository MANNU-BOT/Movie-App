package com.example.movies

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.grid.*

class Grid : AppCompatActivity() {

    val action = arrayOf(
        R.drawable.ac1,
        R.drawable.ac2,
        R.drawable.ac3,
        R.drawable.ac4,
        R.drawable.ac5,
        R.drawable.ac6,
        R.drawable.ac7,
        R.drawable.ac8,
        R.drawable.ac9,
        R.drawable.ac10,
        R.drawable.ac11,
        R.drawable.ac12,
        R.drawable.ac13,
        R.drawable.ac14,
        R.drawable.ac15,
        R.drawable.ac16,
        R.drawable.ac17,
        R.drawable.ac18,
        R.drawable.ac19,
        R.drawable.ac20,
        R.drawable.ac21,
        R.drawable.ac22,
        R.drawable.ac23,
        R.drawable.ac24
    )

    val horror = arrayOf(
        R.drawable.hor1,
        R.drawable.hor2,
        R.drawable.hor3,
        R.drawable.hor4,
        R.drawable.hor5,
        R.drawable.hor6,
        R.drawable.hor7,
        R.drawable.hor8,
        R.drawable.hor9,
        R.drawable.hor10,
        R.drawable.hor11,
        R.drawable.hor12,
        R.drawable.hor13,
        R.drawable.hor14,
        R.drawable.hor15,
        R.drawable.hor16,
        R.drawable.hor17,
        R.drawable.hor18,
        R.drawable.hor19,
        R.drawable.hor20,
        R.drawable.hor21,
        R.drawable.hor22,
        R.drawable.hor23,
        R.drawable.hor24
    )

    val anime = arrayOf(
        R.drawable.ani1,
        R.drawable.ani2,
        R.drawable.ani3,
        R.drawable.ani4,
        R.drawable.ani5,
        R.drawable.ani6,
        R.drawable.ani7,
        R.drawable.ani8,
        R.drawable.ani9,
        R.drawable.ani10,
        R.drawable.ani11,
        R.drawable.ani12,
        R.drawable.ani13,
        R.drawable.ani14,
        R.drawable.ani15,
        R.drawable.ani16,
        R.drawable.ani17,
        R.drawable.ani18,
        R.drawable.ani19,
        R.drawable.ani20,
        R.drawable.ani21,
        R.drawable.ani22,
        R.drawable.ani23,
        R.drawable.ani24
    )

    val comedy = arrayOf(
        R.drawable.com1,
        R.drawable.com2,
        R.drawable.com3,
        R.drawable.com4,
        R.drawable.com5,
        R.drawable.com6,
        R.drawable.com7,
        R.drawable.com8,
        R.drawable.com9,
        R.drawable.com10,
        R.drawable.com11,
        R.drawable.com12,
        R.drawable.com13,
        R.drawable.com14,
        R.drawable.com15,
        R.drawable.com16,
        R.drawable.com17,
        R.drawable.com18,
        R.drawable.com19,
        R.drawable.com20,
        R.drawable.com21,
        R.drawable.com22,
        R.drawable.com23,
        R.drawable.com24
    )

    val animated = arrayOf(
        R.drawable.anim1,
        R.drawable.anim2,
        R.drawable.anim3,
        R.drawable.anim4,
        R.drawable.anim5,
        R.drawable.anim6,
        R.drawable.anim7,
        R.drawable.anim8,
        R.drawable.anim9,
        R.drawable.anim10,
        R.drawable.anim11,
        R.drawable.anim12,
        R.drawable.anim13,
        R.drawable.anim14,
        R.drawable.anim15,
        R.drawable.anim16,
        R.drawable.anim17,
        R.drawable.anim18,
        R.drawable.anim19,
        R.drawable.anim20,
        R.drawable.anim21,
        R.drawable.anim22,
        R.drawable.anim23,
        R.drawable.anim24
    )

    var change=IntArray(23)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.grid)

        val bun = intent.extras

        when (bun!!.getString("key")) {

            "one"-> comGrid.visibility= View.VISIBLE
        }




    }
}
