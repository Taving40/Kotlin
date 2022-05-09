package com.example.helloworld

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class ItemAdapter(private val itemsList: ArrayList<Item>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = itemsList[position]
//        holder.itemImage.setImageResource(currentItem.imageIndex)
        holder.itemContent.text = currentItem.content
    }

    override fun getItemCount(): Int {
       return itemsList.size
    }

    class ItemViewHolder( itemView: View): RecyclerView.ViewHolder(itemView){

//        val itemImage : CircleImageView = itemView.findViewById(R.id.item_image)
        val itemContent : TextView = itemView.findViewById(R.id.item_content)
    }
}
