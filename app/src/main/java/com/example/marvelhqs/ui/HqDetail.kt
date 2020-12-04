package com.example.marvelhqs.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelhqs.R
import com.example.marvelhqs.viewModel.HqDetailViewModel

class HqDetail : Fragment() {

    companion object {
        fun newInstance() = HqDetail()
    }

    private lateinit var viewModel: HqDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        (activity as AppCompatActivity).supportActionBar?.hide()
        return inflater.inflate(R.layout.hq_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HqDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

    inner class HqViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var HqCover: ImageView = itemView.findViewById(R.id.imgCover)
        var HqNumero: TextView = itemView.findViewById(R.id.txtNumeroHQ)
        var HqSinopse: TextView = itemView.findViewById(R.id.txtSinopse)
        var HqTitulo: TextView = itemView.findViewById(R.id.txtTitulo)
        var HqData: TextView = itemView.findViewById(R.id.txtDataPublicacao)
        var HqPreco: TextView = itemView.findViewById(R.id.txtPreco)
        var HqPaginas: TextView = itemView.findViewById(R.id.txtPaginas)
    }

}