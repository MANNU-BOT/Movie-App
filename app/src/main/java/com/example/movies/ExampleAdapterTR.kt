package com.example.movies

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item3.view.*

class ExampleAdapterTR(con: Context, private val elist: List<ExampleItemTR>) :
    RecyclerView.Adapter<ExampleAdapterTR.EVHTR>() {

    private val c: Context = con
    private val e = elist


    class EVHTR(i: View) : RecyclerView.ViewHolder(i) {
        val imge: ImageView = i.trimg
        val rate: RatingBar = i.trR
        val idtext: TextView = i.tritemID
        val resTR: RelativeLayout = i.trcard
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EVHTR {
        val p = LayoutInflater.from(parent.context).inflate(R.layout.item3, parent, false)
        return EVHTR(p)
    }

    override fun getItemCount() = e.size

    override fun onBindViewHolder(holder: EVHTR, position: Int) {
        val currentitem = elist[position]
        val temp="https://image.tmdb.org/t/p/w342${currentitem.poster}"
        Picasso.with(c).load(temp).into(holder.imge)
        holder.rate.rating = currentitem.rating.toFloat()
        holder.idtext.text = currentitem.itemIDtr

        holder.resTR.setOnClickListener {

            Toast.makeText(c, "Rating-${currentitem.rating}", Toast.LENGTH_SHORT).show()
            val it = Intent(c, movie2::class.java)
            it.putExtra("mov", currentitem.itemIDtr)
            c.startActivity(it)
        }

    }
}