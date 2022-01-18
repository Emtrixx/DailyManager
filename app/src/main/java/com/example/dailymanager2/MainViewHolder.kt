package com.example.dailymanager2

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dailymanager2.databinding.RvItemBinding

class MainViewHolder(val itemBinding: RvItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    private val name: TextView = itemView.findViewById<View>(R.id.itemName) as TextView
    private val location: TextView = itemView.findViewById<View>(R.id.itemLocation) as TextView
    private val time: TextView = itemView.findViewById<View>(R.id.itemTime) as TextView
    private val note: TextView = itemView.findViewById<View>(R.id.itemNote) as TextView

    init {
        //TODO please initialize your views from R.layout.item here
        //TODO set listener for views
    }

    fun bindItem(entry: Entry) {
        itemBinding.itemName.text = entry.name
        itemBinding.itemTime.text = entry.time
        itemBinding.itemLocation.text = entry.location
        itemBinding.itemNote.text = entry.note
    }
}