package com.example.dailymanager2

import androidx.recyclerview.widget.RecyclerView
import com.example.dailymanager2.databinding.RvItemBinding

class MainViewHolder(private val itemBinding: RvItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
    fun bindItem(entry: Entry) {
        itemBinding.itemName.text = entry.name
        itemBinding.itemTime.text = entry.time
        itemBinding.itemLocation.text = entry.location
        itemBinding.itemNote.text = entry.note
    }
}