package com.example.wisdomshare

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var editEmail : EditText
    private lateinit var editPassword : EditText
    private lateinit var btnLogin : Button
    private lateinit var btnSignup : Button

    private lateinit var mAuth : FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        mAuth = FirebaseAuth.getInstance()

        editEmail = findViewById(R.id.Email)
        editPassword = findViewById(R.id.Password)
        btnLogin = findViewById(R.id.LoginB)
        btnSignup = findViewById(R.id.RegB)

        btnSignup.setOnClickListener(){
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener(){
            val email = editEmail.text.toString()
            val password = editPassword.text.toString()

            login(email, password)
        }
    }

    private fun login(email: String, password: String){
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this, MainActivity::class.java)
                    finish()
                    startActivity(intent)
                } else {
                    if (password.length<6) { Toast.makeText(this@Login, "Короткий Пароль", Toast.LENGTH_SHORT).show() }
                    else { Toast.makeText(this@Login, "Ошибка", Toast.LENGTH_SHORT).show() }
                }
            }
    }
}