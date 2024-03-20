package com.example.introduction

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HomrActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homr)

        val btn = findViewById<Button>(R.id.btn_end)
        val tv_id = findViewById<TextView>(R.id.tv_id)
        val strData = intent.getStringExtra("login")
        tv_id.setText(strData)

        btn.setOnClickListener {
            finish()
        }
    }
}