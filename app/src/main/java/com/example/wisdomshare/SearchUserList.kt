package com.example.wisdomshare

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SearchUserList : AppCompatActivity() {

    private lateinit var userRecyclerView : RecyclerView
    private lateinit var userList: ArrayList<User>
    private lateinit var adapter: UserAdapterSearch

    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_user_list)

        mDbRef = FirebaseDatabase.getInstance().getReference()
        mAuth = FirebaseAuth.getInstance()

        userList = ArrayList()
        adapter = UserAdapterSearch(this, userList)

        val skill = intent.getStringExtra("skill")
        supportActionBar?.hide()

        userRecyclerView = findViewById(R.id.userReView)
        userRecyclerView.layoutManager = LinearLayoutManager(this)
        userRecyclerView.adapter = adapter

        mDbRef.child("user").addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                userList.clear()
                for (postSnapshot in snapshot.children){
                    val curUser = postSnapshot.getValue(User::class.java)
                    if (mAuth.currentUser?.uid != curUser?.uid && curUser?.skill.equals(skill)){
                        userList.add(curUser!!)
                    }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })

    }
}