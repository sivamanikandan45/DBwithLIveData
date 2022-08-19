package com.example.dbwithlivedata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ListAdapter:RecyclerView.Adapter<com.example.dbwithlivedata.ListAdapter.ViewHolder>() {

    var list = ArrayList<User>()

    fun setData(list:ArrayList<User>){
        this.list= list
    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val text:TextView
        init {
            text=view.findViewById(R.id.name)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.text=list[position].name
        //holder.text.text=list.value?.get(position)!!.name

    }

    override fun getItemCount(): Int {
        return list.size
    }
}