package com.example.marvelhqs.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.marvelhqs.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.setIcon(R.drawable.ic_marvel_logo_icon)
        supportActionBar?.setTitle("")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}