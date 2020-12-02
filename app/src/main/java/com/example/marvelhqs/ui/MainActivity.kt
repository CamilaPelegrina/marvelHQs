package com.example.marvelhqs.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelhqs.HqDetailViewModel
import com.example.marvelhqs.R

class MainActivity : AppCompatActivity() {
    private val viewModel: HqDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.setIcon(R.drawable.ic_marvel_logo_icon)
        supportActionBar?.setTitle("")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerHQs()
    }

    private fun initRecyclerHQs() {
        val listaHQs = viewModel.getHQs()
        val recycler = findViewById<RecyclerView>(R.id.rv_recyclerHome)
        recycler.adapter = HqAdapter(listaHQs)
        recycler.apply {
            layoutManager = GridLayoutManager(context, 3)
        }

        recycler.setHasFixedSize(true)
    }
}