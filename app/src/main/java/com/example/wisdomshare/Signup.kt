package com.example.wisdomshare

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Signup : AppCompatActivity() {

    private lateinit var editName : EditText
    private lateinit var editEmail : EditText
    private lateinit var editPassword : EditText
    private lateinit var btnSignup : Button

    private lateinit var mAuth : FirebaseAuth
    private lateinit var mDbRef : DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)

        supportActionBar?.hide()

        mAuth = FirebaseAuth.getInstance()

        editName = findViewById(R.id.User)
        editEmail = findViewById(R.id.Email)
        editPassword = findViewById(R.id.Password)
        btnSignup = findViewById(R.id.RegB)

        btnSignup.setOnClickListener(){
            val name = editName.text.toString()
            val email = editEmail.text.toString()
            val password = editPassword.text.toString()

            signup(email, password, name)
        }
    }

    private fun signup(email: String, password: String, name: String){
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    addUserToDataBase(name, email, mAuth.currentUser?.uid!!)
                    val intent = Intent(this, SkillChoose::class.java)
                    intent.putExtra("name", name)
                    intent.putExtra("email", email)
                    intent.putExtra("uid", mAuth.currentUser?.uid!!)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@Signup, "Ошибка", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun addUserToDataBase(name: String, email: String, uid: String){
        mDbRef = FirebaseDatabase.getInstance().getReference()
        mDbRef.child("user").child(uid).setValue(User(name, email, uid, "default", null))
    }
}