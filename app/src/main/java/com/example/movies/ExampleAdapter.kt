package com.example.movies

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item.view.*

class ExampleAdapter(con: Context, private val elist: List<ExampleItem>) : RecyclerView.Adapter<ExampleAdapter.EVH>()
{

    private val c: Context = con
    private val e = elist


    class EVH(i: View) : RecyclerView.ViewHolder(i) {
        val imge: ImageView = i.iS
        val tx1: TextView = i.iT1
        val tx2: TextView = i.iT2

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EVH {
        val p = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return EVH(p)
    }

    override fun getItemCount() = e.size


    override fun onBindViewHolder(holder: EVH, position: Int) {
        val currentitem = elist[position]
        holder.tx1.text = currentitem.title
        holder.tx2.text = currentitem.yr
        Picasso.with(c).load(currentitem.img).into(holder.imge)
    }


}