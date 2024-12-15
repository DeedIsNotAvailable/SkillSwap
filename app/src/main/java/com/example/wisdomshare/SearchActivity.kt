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

class SearchActivity : AppCompatActivity() {
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

    private lateinit var chatsB: Button
    private lateinit var profileB: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

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

        chatsB = findViewById(R.id.chatsButton)
        profileB = findViewById(R.id.profileButton)

        chatsB.setOnClickListener(){
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        }

        profileB.setOnClickListener(){
            finish()
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        mAuth = FirebaseAuth.getInstance()
        mDbRef = FirebaseDatabase.getInstance().getReference()

        runButton.setOnClickListener(){
            val intent = Intent(this, SearchUserList::class.java)
            intent.putExtra("skill", "Бег")
            finish()
            startActivity(intent)
        }
        swimButton.setOnClickListener(){
            val intent = Intent(this, SearchUserList::class.java)
            intent.putExtra("skill", "Плавание")
            finish()
            startActivity(intent)
        }
        bicycleButton.setOnClickListener(){
            val intent = Intent(this, SearchUserList::class.java)
            intent.putExtra("skill", "Велосипед")
            finish()
            startActivity(intent)
        }
        footballButton.setOnClickListener(){
            val intent = Intent(this, SearchUserList::class.java)
            intent.putExtra("skill", "Футбол")
            finish()
            startActivity(intent)
        }
        basketButton.setOnClickListener(){
            val intent = Intent(this, SearchUserList::class.java)
            intent.putExtra("skill", "Баскетбол")
            finish()
            startActivity(intent)
        }
        hockyButton.setOnClickListener(){
            val intent = Intent(this, SearchUserList::class.java)
            intent.putExtra("skill", "Хоккей")
            finish()
            startActivity(intent)
        }
        chessButton.setOnClickListener(){
            val intent = Intent(this, SearchUserList::class.java)
            intent.putExtra("skill", "Шахматы")
            finish()
            startActivity(intent)
        }
        violinButton.setOnClickListener(){
            val intent = Intent(this, SearchUserList::class.java)
            intent.putExtra("skill", "Скрипка")
            finish()
            startActivity(intent)
        }
        pianoButton.setOnClickListener(){
            val intent = Intent(this, SearchUserList::class.java)
            intent.putExtra("skill", "Пианино")
            finish()
            startActivity(intent)
        }
        guitarButton.setOnClickListener(){
            val intent = Intent(this, SearchUserList::class.java)
            intent.putExtra("skill", "Гитара")
            finish()
            startActivity(intent)
        }
        drummButton.setOnClickListener(){
            val intent = Intent(this, SearchUserList::class.java)
            intent.putExtra("skill", "Барабаны")
            finish()
            startActivity(intent)
        }
        accordButton.setOnClickListener(){
            val intent = Intent(this, SearchUserList::class.java)
            intent.putExtra("skill", "Аккордеон")
            finish()
            startActivity(intent)
        }
        drawingButton.setOnClickListener(){
            val intent = Intent(this, SearchUserList::class.java)
            intent.putExtra("skill", "Рисование")
            finish()
            startActivity(intent)
        }
        cookingButton.setOnClickListener(){
            val intent = Intent(this, SearchUserList::class.java)
            intent.putExtra("skill", "Готовка")
            finish()
            startActivity(intent)
        }
        sewingButton.setOnClickListener(){
            val intent = Intent(this, SearchUserList::class.java)
            intent.putExtra("skill", "Шитье")
            finish()
            startActivity(intent)
        }
    }
}