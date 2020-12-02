package com.example.marvelhqs.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelhqs.R

class HqAdapter(
        private val listaConfiguracoes: ArrayList<HQ>
) : RecyclerView.Adapter<HqAdapter.HqViewHolder>() {

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): HqAdapter.HqViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.hq_cover,
                parent,
                false
        )
        return HqViewHolder(itemView)
    }

    override fun onBindViewHolder(
            holder: HqAdapter.HqViewHolder,
            position: Int
    ) {

        var hq = listaConfiguracoes.get(position)
        holder.HqCover.setImageResource(hq.cover)
        holder.HqNumero.text = hq.numero
    }

    override fun getItemCount(): Int = listaConfiguracoes.size

    inner class HqViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var HqCover: ImageView = itemView.findViewById(R.id.imgCover)
        var HqNumero: TextView = itemView.findViewById(R.id.txtNumeroHQ)
    }
}