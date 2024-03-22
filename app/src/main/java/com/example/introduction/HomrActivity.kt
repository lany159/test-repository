package com.example.introduction

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.Random

class HomrActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homr)

        val btn = findViewById<Button>(R.id.btn_end)
        val tv_id = findViewById<TextView>(R.id.tv_id)
        val strData = intent.getStringExtra("login")
        tv_id.setText(strData)

        val iv_profil = findViewById<ImageView>(R.id.iv_profile_w)
        when(Random().nextInt(5)){
            0 -> iv_profil.setImageResource(R.drawable.woman_profil1)
            1 -> iv_profil.setImageResource(R.drawable.woman_profil2)
            2 -> iv_profil.setImageResource(R.drawable.woman_profil3)
            3 -> iv_profil.setImageResource(R.drawable.woman_profil4)
            4 -> iv_profil.setImageResource(R.drawable.woman_profil5)
        }

        btn.setOnClickListener {
            finish()
        }
    }
}