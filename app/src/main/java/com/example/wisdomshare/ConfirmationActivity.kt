package com.example.wisdomshare

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ConfirmationActivity : AppCompatActivity() {

    private lateinit var mDbRef : DatabaseReference
    private lateinit var mAuth: FirebaseAuth

    private lateinit var buttonC: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)
        supportActionBar?.hide()

        mDbRef = FirebaseDatabase.getInstance().getReference()
        mAuth = FirebaseAuth.getInstance()

        val frienduid = intent.getStringExtra("uid")
        mDbRef.child("user").child(mAuth.currentUser?.uid!!).child("friends").push().setValue(frienduid)

        buttonC = findViewById(R.id.buttonС)
        buttonC.setOnClickListener(){
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}