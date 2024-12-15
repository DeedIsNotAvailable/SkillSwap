package com.example.wisdomshare

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {

    private lateinit var userRecyclerView : RecyclerView
    private lateinit var userList: ArrayList<User>
    private lateinit var friendsList: ArrayList<String>
    private lateinit var adapter: UserAdapter

    private lateinit var srcB: Button
    private lateinit var profileB: Button

    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        mDbRef = FirebaseDatabase.getInstance().getReference()
        mAuth = FirebaseAuth.getInstance()

        userList = ArrayList()
        friendsList = ArrayList()
        adapter = UserAdapter(this, userList)

        srcB = findViewById(R.id.searchButton)
        profileB = findViewById(R.id.profileButton)

        srcB.setOnClickListener(){
            finish()
            startActivity(Intent(this, SearchActivity::class.java))
        }

        profileB.setOnClickListener(){
            finish()
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        userRecyclerView = findViewById(R.id.userReView)
        userRecyclerView.layoutManager = LinearLayoutManager(this)
        userRecyclerView.adapter = adapter

        //смотрим друзей юзера
        mDbRef.child("user").child(mAuth.currentUser?.uid!!).child("friends")
            .addListenerForSingleValueEvent(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                friendsList.clear()

                for (postSnapshot in snapshot.children){                                // просматриваем каждого друга
                    val curUserFriend = postSnapshot.getValue(String::class.java)       //друг которого смотрим
                    friendsList.add(curUserFriend!!)                                    //добавляем в фр

                    mDbRef.child("user").child(curUserFriend).child("friends")          //проверям друзей друга
                        .addListenerForSingleValueEvent(object: ValueEventListener{

                            override fun onDataChange(snapshot: DataSnapshot) {
                                val omegafr = ArrayList<String?>()                      //список друзей друга
                                for (postSnapshot in snapshot.children){
                                    val curUserFriendFriend = postSnapshot.getValue(String::class.java)
                                    omegafr.add(curUserFriendFriend)
                                }
                                if (!omegafr.contains(mAuth.currentUser?.uid)){
                                    mDbRef.child("user").child(curUserFriend!!).child("friends").push().setValue(mAuth.currentUser?.uid)
                                }
                            }
                            override fun onCancelled(error: DatabaseError) {
                            }
                        })
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })


        //выводим
        mDbRef.child("user").addListenerForSingleValueEvent(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                userList.clear()
                for (postSnapshot in snapshot.children){
                    for (friend in friendsList){
                        val curUser = postSnapshot.getValue(User::class.java)
                        if (curUser?.uid == friend){
                            userList.add(curUser!!)
                        }
                    }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })

        //добавляем другому пользователю чат
    }
}