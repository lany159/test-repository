package com.example.introduction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    //ActivityResultLauncher라는 타입 resultLauncher 선언
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btn_login)
        val btn_signUp = findViewById<Button>(R.id.btn_signup)
        val et_id = findViewById<EditText>(R.id.et_id)
        val et_pw = findViewById<EditText>(R.id.et_pw)

        btn.setOnClickListener {

            if (et_id.text.isEmpty()) {
                Toast.makeText(this, "아이디를 입력해주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (et_pw.text.isEmpty()) {
                Toast.makeText(this, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()

            val strData = et_id.text.toString()
            val intent = Intent(this, HomrActivity::class.java)
            intent.putExtra("login", strData)
            startActivity(intent)
        }

        btn_signUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            resultLauncher.launch(intent)
            //StartActivityForResult() 동일 기능
        }

        resultLauncher =
            //resultLauncher 변수에 registerForActivityResult() 활용
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                //회원가입 엑티비티에서 결과 값을 받아올 수 있는 구문
                if (result.resultCode == RESULT_OK) {
                    //resultCode 의 역할? 기본값: RESULT_OK , 여러 화면 이동 가정, 데이터도 함께 이동, 구분이 필요하기 때문에 사용
                    val id = result.data?.getStringExtra("id") ?: ""
                    val pw = result.data?.getStringExtra("pw") ?: ""

                    et_id.setText(id)
                    et_pw.setText(pw)
                }
            }
    }
}

