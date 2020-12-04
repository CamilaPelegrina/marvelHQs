package com.example.marvelhqs.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelhqs.R
import com.example.marvelhqs.adapters.HqAdapter
import com.example.marvelhqs.service.repository
import com.example.marvelhqs.viewModel.HqDetailViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class FragmentHome : Fragment() {

    lateinit var HqAdapter: HqAdapter
    lateinit var GridLayoutManager: GridLayoutManager
    var offset = 0
    var limit = 12

    val viewModel by viewModels<HqDetailViewModel>{
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return HqDetailViewModel(repository) as T
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (activity as AppCompatActivity).supportActionBar?.setIcon(R.drawable.ic_marvel_logo_icon)
        (activity as AppCompatActivity).supportActionBar?.setTitle("MARVEL")

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        return  view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        HqAdapter = HqAdapter(this)
        rv_recyclerHome.adapter = HqAdapter
        rv_recyclerHome.apply {
            layoutManager = GridLayoutManager(context, 3)
        }
        rv_recyclerHome.setHasFixedSize(true)

        viewModel.listaHQs.observe(this) {
            HqAdapter.addList(it)
        }

        viewModel.getHQs(offset)

        setScroller()
    }

    fun setScroller() {
        rv_recyclerHome.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0) {
                    val viewedItens = GridLayoutManager.childCount
                    val vitem = GridLayoutManager.findFirstCompletelyVisibleItemPosition()
                    val totalItens = HqAdapter.itemCount
                    if (viewedItens + vitem >= totalItens) {
                        Log.i("TAG", dy.toString())
                        offset += limit
                        viewModel.getHQs(offset)
                    }
                }
            }
        })
    }

}