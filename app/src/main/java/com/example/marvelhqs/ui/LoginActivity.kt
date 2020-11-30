package com.example.marvelhqs.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.marvelhqs.R


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<Button>(R.id.btnLogin).setOnClickListener {
            callMain()
        }

        findViewById<TextView>(R.id.txtRegister).setOnClickListener {
            callCadastro()
        }

    }

    private fun callMain(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun callCadastro(){
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}