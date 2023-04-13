package com.example.roomdatabase

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.databinding.ItemListBinding

class RoomDataAdpter(private val context: Context, val itemList: List<UserData>, val onclick: (Int, Int,UserData) -> Unit) :
    RecyclerView.Adapter<RoomDataAdpter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onItem(position: Int) {
           val List=itemList[position]
            binding.tvfirstname.text = itemList[position].firstname
            binding.tvlastname.text = itemList[position].lastname
            binding.tvroll.text = List.roll

            binding.btnupDate.setOnClickListener {
                onclick.invoke(itemList[position].id,0,itemList[position])
            }
            binding.btndelete.setOnClickListener {
                onclick.invoke(itemList[position].id,1,itemList[position])
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onItem(position)
    }

}