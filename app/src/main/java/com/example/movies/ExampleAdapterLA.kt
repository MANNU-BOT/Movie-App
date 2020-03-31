package com.example.movies

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item2.view.*

class ExampleAdapterLA(con: Context, private val elist: List<ExampleItemLA>) :
    RecyclerView.Adapter<ExampleAdapterLA.EVHLA>() {

    private val c: Context = con
    private val e = elist

    class EVHLA(i: View) : RecyclerView.ViewHolder(i) {
        val imgeL: ImageView = i.limg
        val tx1: TextView = i.lT1
        val tx2: TextView = i.lT2
        val tx3: TextView = i.lT3
        val itmID: TextView = i.litemID
        val resLA: RelativeLayout = i.lCard
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EVHLA {
        val p = LayoutInflater.from(parent.context).inflate(R.layout.item2, parent, false)
        return EVHLA(p)
    }

    override fun getItemCount() = e.size


    override fun onBindViewHolder(holder: EVHLA, position: Int) {
        val currentitem = elist[position]
        val temp="https://image.tmdb.org/t/p/w154${currentitem.poster}"
        Picasso.with(c).load(temp).into(holder.imgeL)
        holder.tx1.text = currentitem.title
        holder.tx2.text = "Popularity-"+currentitem.popularity
        holder.tx3.text=currentitem.yr
        holder.itmID.text = currentitem.itemID

        holder.resLA.setOnClickListener {

            Toast.makeText(c, "Movie Name-${currentitem.title}", Toast.LENGTH_SHORT).show()
            val it = Intent(c, movie2::class.java)
            it.putExtra("mov", currentitem.itemID)
            c.startActivity(it)
        }


    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    //The above two function prevents data to duplicate

}