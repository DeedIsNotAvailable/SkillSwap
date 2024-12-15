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

class SkillChoose : AppCompatActivity() {

    private lateinit var mAuth : FirebaseAuth
    private lateinit var mDbRef : DatabaseReference

    private lateinit var runButton : Button
    private lateinit var swimButton : Button
    private lateinit var bicycleButton : Button
    private lateinit var footballButton : Button
    private lateinit var basketButton : Button
    private lateinit var hockyButton : Button
    private lateinit var chessButton : Button
    private lateinit var violinButton : Button
    private lateinit var pianoButton : Button
    private lateinit var guitarButton : Button
    private lateinit var drummButton : Button
    private lateinit var accordButton : Button
    private lateinit var drawingButton : Button
    private lateinit var cookingButton : Button
    private lateinit var sewingButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill_choose)

        supportActionBar?.hide()

        runButton = findViewById(R.id.runButton)
        swimButton = findViewById(R.id.swimButton)
        bicycleButton = findViewById(R.id.bicycleButton)
        footballButton = findViewById(R.id.footballButton)
        basketButton = findViewById(R.id.basketButton)
        hockyButton = findViewById(R.id.hockyButton)
        chessButton = findViewById(R.id.chessButton)
        violinButton = findViewById(R.id.violinButton)
        pianoButton = findViewById(R.id.pianoButton)
        guitarButton = findViewById(R.id.guitarButton)
        drummButton = findViewById(R.id.drummButton)
        accordButton = findViewById(R.id.accordButton)
        drawingButton = findViewById(R.id.drawingButton)
        cookingButton = findViewById(R.id.cookingButton)
        sewingButton = findViewById(R.id.sewingButton)

        mAuth = FirebaseAuth.getInstance()
        mDbRef = FirebaseDatabase.getInstance().getReference()
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val uid = intent.getStringExtra("uid")

        runButton.setOnClickListener(){
            mDbRef.child("user").child(mAuth.currentUser?.uid!!).setValue(User(name, email, uid, "Бег", ArrayList()))
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        }
        swimButton.setOnClickListener(){
            mDbRef.child("user").child(mAuth.currentUser?.uid!!).setValue(User(name, email, uid, "Плавание", ArrayList()))
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        }
        bicycleButton.setOnClickListener(){
            mDbRef.child("user").child(mAuth.currentUser?.uid!!).setValue(User(name, email, uid, "Велосипед", ArrayList()))
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        }
        footballButton.setOnClickListener(){
            mDbRef.child("user").child(mAuth.currentUser?.uid!!).setValue(User(name, email, uid, "Футбол", ArrayList()))
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        }
        basketButton.setOnClickListener(){
            mDbRef.child("user").child(mAuth.currentUser?.uid!!).setValue(User(name, email, uid, "Баскетбол", ArrayList()))
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        }
        hockyButton.setOnClickListener(){
            mDbRef.child("user").child(mAuth.currentUser?.uid!!).setValue(User(name, email, uid, "Хоккей", ArrayList()))
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        }
        chessButton.setOnClickListener(){
            mDbRef.child("user").child(mAuth.currentUser?.uid!!).setValue(User(name, email, uid, "Шахматы", ArrayList()))
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        }
        violinButton.setOnClickListener(){
            mDbRef.child("user").child(mAuth.currentUser?.uid!!).setValue(User(name, email, uid, "Скрипка", ArrayList()))
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        }
        pianoButton.setOnClickListener(){
            mDbRef.child("user").child(mAuth.currentUser?.uid!!).setValue(User(name, email, uid, "Пианино", ArrayList()))
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        }
        guitarButton.setOnClickListener(){
            mDbRef.child("user").child(mAuth.currentUser?.uid!!).setValue(User(name, email, uid, "Гитара", ArrayList()))
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        }
        drummButton.setOnClickListener(){
            mDbRef.child("user").child(mAuth.currentUser?.uid!!).setValue(User(name, email, uid, "Барабаны", ArrayList()))
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        }
        accordButton.setOnClickListener(){
            mDbRef.child("user").child(mAuth.currentUser?.uid!!).setValue(User(name, email, uid, "Аккордеон", ArrayList()))
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        }
        drawingButton.setOnClickListener(){
            mDbRef.child("user").child(mAuth.currentUser?.uid!!).setValue(User(name, email, uid, "Рисование", ArrayList()))
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        }
        cookingButton.setOnClickListener(){
            mDbRef.child("user").child(mAuth.currentUser?.uid!!).setValue(User(name, email, uid, "Готовка", ArrayList()))
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        }
        sewingButton.setOnClickListener(){
            mDbRef.child("user").child(mAuth.currentUser?.uid!!).setValue(User(name, email, uid, "Шитье", ArrayList()))
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}