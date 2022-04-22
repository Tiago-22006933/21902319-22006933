package com.example.fogospt.ui.fires

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fogospt.R
import com.example.fogospt.ui.model.FireModel

class MyAdapter(private val list: List<FireModel>, private val listener: OnItemClickListener) : RecyclerView.Adapter<MyAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_fire, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = list[position]
        holder.index.text = "Fogo ${position +1 }"
        holder.nome.text = "Nome: " + currentItem.name
        holder.data.text = "Data: " + currentItem.data.year + "/" + currentItem.data.month + "/" + currentItem.data.day + "/"

    }

    override fun getItemCount() = list.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val index: TextView = itemView.findViewById(R.id.fogoIndex)
        val nome: TextView = itemView.findViewById(R.id.nome)
        val data: TextView = itemView.findViewById(R.id.data)

        init{
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}