package com.example.mvi_architecture_android_beginners.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvi_architecture_android_beginners.R
import com.example.mvi_architecture_android_beginners.data.model.User

class UserAdapter(private val userList:ArrayList<User>,):RecyclerView.Adapter<UserAdapter.UserHolder>() {
    class UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user:User)
        {

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return UserHolder(view)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
       return userList.size
    }
    fun addData(list: List<User>) {
        userList.addAll(list)
    }
}