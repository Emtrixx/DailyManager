package com.example.dailymanager2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dailymanager2.databinding.RvItemBinding

class MainAdapter(private val list: ArrayList<Entry>):RecyclerView.Adapter<MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val entry = list[position]
        holder.bindItem(entry)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}