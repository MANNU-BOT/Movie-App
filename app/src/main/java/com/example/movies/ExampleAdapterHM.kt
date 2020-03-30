package com.example.movies

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item4.view.*

class ExampleAdapterHM(con: Context, private val elist: List<ExampleItemHM>) :
    RecyclerView.Adapter<ExampleAdapterHM.EVHHM>() {

    private val c: Context = con
    private val e = elist

    class EVHHM(i: View) : RecyclerView.ViewHolder(i) {
        val imge: ImageView = i.imageH
        val txt: TextView = i.itemIDH
        val txt2:TextView=i.votei4
        val txt3:TextView=i.ratei4
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EVHHM {
        val p = LayoutInflater.from(parent.context).inflate(R.layout.item4, parent, false)
        return EVHHM(p)
    }

    override fun getItemCount() = e.size

    override fun onBindViewHolder(holder: EVHHM, position: Int) {
        val currentitem = elist[position]
        if(currentitem.poster=="null"){
            Picasso.with(c).load("https://www.vpa.net/wp-content/uploads/2018/08/Error-Message.png").into(
                holder.imge)
        }else {
            val temp = "https://image.tmdb.org/t/p/w154${currentitem.poster}"
            Picasso.with(c).load(temp).into(holder.imge)
        }
        holder.txt.text = currentitem.itemid
        holder.txt2.text=currentitem.vote
        holder.txt3.text=currentitem.rate
        holder.imge.setOnClickListener {

            val it = Intent(c, movie2::class.java)
            it.putExtra("mov", currentitem.itemid)
            c.startActivity(it)
        }
    }
}