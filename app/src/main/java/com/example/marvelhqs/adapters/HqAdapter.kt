package com.example.marvelhqs.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvelhqs.R
import com.example.marvelhqs.domain.Results
import com.example.marvelhqs.domain.replaceHttps
import com.example.marvelhqs.ui.FragmentHome
import com.example.marvelhqs.ui.HqDetail
import com.example.marvelhqs.ui.MainActivity
import kotlinx.android.synthetic.main.hq_cover.view.*

class HqAdapter(val listener: FragmentHome) : RecyclerView.Adapter<HqAdapter.HqViewHolder>() {

    var listaHq = ArrayList<Results>()

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): HqViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.hq_cover,
                parent,
                false
        )
        return HqViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HqViewHolder, position: Int) {
        var hq = listaHq[position]
        Glide.with(holder.itemView.context).asBitmap()
            .load(replaceHttps("${hq.thumbnail.path}.${hq.thumbnail.extension}"))
            .into(holder.HqCover)
        holder.HqNumero.text = "#${hq.issueNumber}"



        holder.itemView.setOnClickListener {

            MainActivity.fm.beginTransaction().replace(R.id.fragmentContainer, HqDetail(), null)
                .addToBackStack(null).commit()
        }
    }

    override fun getItemCount(): Int = listaHq.size

    fun addList(list: ArrayList<Results>){
        listaHq.addAll(list)
        notifyDataSetChanged()
    }

    inner class HqViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var HqCover: ImageView = itemView.imgCover
        var HqNumero: TextView = itemView.txtNumeroHQ

    }
}