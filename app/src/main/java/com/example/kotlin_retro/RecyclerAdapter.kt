package com.example.kotlin_retro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class RecyclerAdapter(


    public val context: FragmentActivity,
    public val searches: ArrayList<Search>,
   public val operations: Operations

) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recyclerview_adapter, parent,
            false
        )
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return searches.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.tvMovieName.text = searches.get(position).title

        Glide.with(context).load(searches.get(position).poster)
            .apply(RequestOptions().centerCrop())
            .into(holder.image)
        //   holder.tvMovieName.text = movieList.get(position).title

    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvMovieName: TextView = itemView.findViewById(R.id.title)
        val image: ImageView = itemView.findViewById(R.id.image)

        init {
            itemView.setOnClickListener {

                val pos = adapterPosition
                if(pos!=-1)
                {
                    operations.updateBtn(searches.get(adapterPosition), adapterPosition)
                }
            }
        }

    }

}