package com.example.wisdomshare

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProfileActivity : AppCompatActivity() {

    private lateinit var chatsB: Button
    private lateinit var profileB: Button

    private lateinit var txtName: TextView
    private lateinit var txtMail: TextView
    private lateinit var txtSkill: TextView

    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        mDbRef = FirebaseDatabase.getInstance().getReference()
        mAuth = FirebaseAuth.getInstance()

        supportActionBar?.hide()
        txtName = findViewById(R.id.txt_name)
        txtMail = findViewById(R.id.email_txt)
        txtSkill = findViewById(R.id.skill_txt)

        chatsB = findViewById(R.id.chatsButton)
        profileB = findViewById(R.id.searchButton)

        mDbRef.child("user").child(mAuth.currentUser?.uid!!)
            .addListenerForSingleValueEvent(object: ValueEventListener{

                override fun onDataChange(snapshot: DataSnapshot) {
                    val curUser = snapshot.getValue(User::class.java)
                    txtName.setText(curUser?.name)
                    txtMail.setText(curUser?.email)
                    txtSkill.setText(curUser?.skill)
                }
                override fun onCancelled(error: DatabaseError) {
                }
            })

        chatsB.setOnClickListener(){
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        }

        profileB.setOnClickListener(){
            finish()
            startActivity(Intent(this, SearchActivity::class.java))
        }
    }
}