package com.example.marvelhqs.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.marvelhqs.R
import com.example.marvelhqs.domain.Date
import com.example.marvelhqs.domain.Price
import com.example.marvelhqs.domain.Results
import com.example.marvelhqs.domain.replaceHttps
import com.example.marvelhqs.viewModel.HqDetailViewModel
import kotlinx.android.synthetic.main.hq_detail_fragment.view.*
import kotlin.properties.Delegates

class HqDetail : Fragment() {

    var listaHq = ArrayList<Results>()
    var listaDate = ArrayList<Date>()
    var listaPrice = ArrayList<Price>()
    var position by Delegates.notNull<Int>()

    private val ViewModel: HqDetailViewModel by activityViewModels()

//    companion object {
//        fun newInstance() = HqDetail()
//    }

    private lateinit var viewModel: HqDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (activity as AppCompatActivity).supportActionBar?.hide()
        return inflater.inflate(R.layout.hq_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        position = arguments?.getInt("position")!!
        val hqSelected = listaHq[position]
        val hqDataSelected = listaDate[position]
        val hqPriceSelected = listaPrice[position]

        view.findViewById<TextView>(R.id.txtTitulo).text = "#${hqSelected.title}"
        Glide.with(this).asBitmap().load(replaceHttps("${hqSelected.thumbnail.path}.${hqSelected.thumbnail.extension}"))
                .into(view.imgHead)
        Glide.with(this).asBitmap().load(replaceHttps("${hqSelected.thumbnail.path}.${hqSelected.thumbnail.extension}"))
                .into(view.img_cover)
        view.findViewById<TextView>(R.id.txtSinopse).text = "#${hqSelected.description}"
        view.findViewById<TextView>(R.id.txtDataPublicacao).text = "#${hqDataSelected.date}"
        view.findViewById<TextView>(R.id.txtPreco).text = "#${hqPriceSelected.price}"
        view.findViewById<TextView>(R.id.txtPaginas).text = "#${hqSelected.pageCount}"

    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(HqDetailViewModel::class.java)
//
//    }

}