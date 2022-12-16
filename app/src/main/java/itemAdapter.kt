package com.example.taleecious
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.taleecious.Details
import com.example.taleecious.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.view.*

class itemAdapter(val taleTitle : Array<String>, val taleContent : Array<String>, val taleImage : Array<String>) : RecyclerView.Adapter<itemAdapter.ViewHolder>() {

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
         val cardTitle : TextView = itemView.findViewById(R.id.cardTitle)
        val cardContent : TextView = itemView.findViewById(R.id.cardContent)
        val cardImage : ImageView = itemView.findViewById(R.id.cardImage)
        val view = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_items,parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cardTitle.text = taleTitle[position]
        holder.cardContent.text = taleContent[position]
        Picasso.get().load(taleImage[position]).into(holder.cardImage)

        holder.view.setOnClickListener {

              val intent : Intent = Intent(it.context, Details::class.java)
              intent.putExtra("TaleTitle", taleTitle[position])
              intent.putExtra("TaleContent", taleContent[position])
              intent.putExtra("TaleImage", taleImage[position])
              //Toast.makeText(holder.view.context, "item number-> "+ position, Toast.LENGTH_SHORT).show()
              holder.view.context.startActivity(intent)
          }
    }


    override fun getItemCount(): Int {
        return taleTitle.size

    }
}

