package com.example.wisdomshare

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wisdomshare.UserAdapter.UserViewHolder
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth

class MessageAdapter(val context: Context, val messageList: ArrayList<Message>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val ITEM_RECEIVE = 1
    val ITEM_SENT = 2

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        if (viewType == 1){
            val view : View = LayoutInflater.from(context).inflate(R.layout.recieved, parent, false)
            return RecievedViewHolder(view)
        }else{
            val view : View = LayoutInflater.from(context).inflate(R.layout.sent, parent, false)
            return SentViewHolder(view)
        }
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        val curMes = messageList[position]

        if (holder.javaClass == SentViewHolder::class.java){
            val viewHolder = holder as SentViewHolder
            holder.sentMessage.text = curMes.message
        }else{
            val viewHolder = holder as RecievedViewHolder
            holder.recievedMessage.text = curMes.message
        }
    }

    override fun getItemViewType(position: Int): Int {
        val curMes = messageList[position]

        if(FirebaseAuth.getInstance().currentUser?.uid.equals(curMes.senderId)){
            return ITEM_SENT
        }else{
            return ITEM_RECEIVE
        }
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    class SentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val sentMessage = itemView.findViewById<TextView>(R.id.txt_sent_message)
    }

    class RecievedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val recievedMessage = itemView.findViewById<TextView>(R.id.txt_recieved_message)
    }
}