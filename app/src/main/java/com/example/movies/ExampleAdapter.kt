package com.example.movies

import android.app.Activity
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
import kotlinx.android.synthetic.main.item.view.*

class ExampleAdapter(con: Context, private val elist: List<ExampleItem>) : RecyclerView.Adapter<ExampleAdapter.EVH>()
{

    private val c: Context = con
    private val e = elist


    class EVH(i: View) : RecyclerView.ViewHolder(i) {
        val imge: ImageView = i.iS
        val tx1: TextView = i.iT1
        val tx2: TextView = i.iT2
        val tx3:TextView=i.iT3
        val res:RelativeLayout=i.result

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EVH {
        val p = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return EVH(p)
    }

    override fun getItemCount() = e.size


    @Suppress("NAME_SHADOWING")
    override fun onBindViewHolder(holder: EVH, position: Int) {
        val currentitem = elist[position]
        holder.tx1.text = currentitem.title
        holder.tx2.text = currentitem.yr
        holder.tx3.text=currentitem.itemid
        Picasso.with(c).load(currentitem.img).into(holder.imge)

        holder.res.setOnClickListener {

            Toast.makeText(c,"Clicked-${currentitem.title}",Toast.LENGTH_SHORT).show()
            val it=Intent(c,movie::class.java)
            it.putExtra("mov",currentitem.itemid)
            c.startActivity(it)
        }

    }



}