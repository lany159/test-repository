package com.example.introduction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btn_login)
        val btn_signUp = findViewById<Button>(R.id.btn_signup)
        val ed_id = findViewById<EditText>(R.id.ev_id)
        val ed_pw = findViewById<EditText>(R.id.ev_pw)

        btn.setOnClickListener {

            if (ed_id.text.isEmpty()){
                Toast.makeText(this, "아이디를 입력해주세요",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (ed_pw.text.isEmpty()){
                Toast.makeText(this, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()

            val strData = ed_id.text.toString()
            val intent = Intent(this, HomrActivity::class.java)
            intent.putExtra("login",strData)
            startActivity(intent)
        }

        btn_signUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}

