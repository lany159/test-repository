package com.example.introduction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val btn = findViewById<Button>(R.id.btn_login)

        btn.setOnClickListener {

            val et_name = findViewById<EditText>(R.id.et_name)
            val strName = et_name.text.toString()
            val et_id = findViewById<EditText>(R.id.et_id)
            val strId = et_id.text.toString()
            val et_pw = findViewById<EditText>(R.id.et_pw)
            val strPw = et_pw.text.toString()

            val isName = strName.isEmpty()
            val isId = strId.isEmpty()
            val isPw = strPw.isEmpty()

            if (isName || isId || isPw){
                Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
            }else{
                intent.putExtra("id",strId)
                intent.putExtra("pw",strPw)
                setResult(RESULT_OK, intent)
                //RESULT_OK는 데이터를 실어서 보내는 역할인가?
                //-1을 RESULT_OK로 받는 것
                //setResult가 데이터를 실어서 보내는 역할인가?
                //intent 생략 가능
                finish()
            }
        }
    }
}