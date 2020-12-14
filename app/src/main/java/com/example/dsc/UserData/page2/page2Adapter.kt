package com.example.dsc.UserData.page2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dsc.R
import com.example.dsc.UserData.UserEntity
import kotlinx.android.synthetic.main.fragment_page1.view.*
import kotlinx.android.synthetic.main.item_rv_page2.view.*

class page2Adapter : RecyclerView.Adapter<page2Adapter.myViewHolder>() {

    private var userList = emptyList<UserEntity>()
    class myViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        return myViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv_page2, parent, false))
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.tv_name.text = currentItem.name
        holder.itemView.tv_address.text = currentItem.address
        holder.itemView.tv_age.text = currentItem.age
    }

    override fun getItemCount(): Int {
       return userList.size
    }

    fun setData(user : List<UserEntity>){
        this.userList = user
        notifyDataSetChanged()
    }
}