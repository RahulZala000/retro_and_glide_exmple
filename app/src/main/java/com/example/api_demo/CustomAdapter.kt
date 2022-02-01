package com.example.api_demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private var mList: List<Data>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //return holder.data(mList[position])

        holder.id.text= mList[position].toString()
        holder.fn.text= mList[position].toString()


    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val id: TextView = itemView.findViewById(R.id.id)
        var fn: TextView = itemView.findViewById(R.id.title)
        var ln: TextView = itemView.findViewById(R.id.title)

        fun data(get: Data) {
            id.text = get.id.toString()
            fn.text = get.first_name
            ln.text = get.last_name

        }

    }
}




