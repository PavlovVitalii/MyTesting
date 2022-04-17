package com.example.mytest.recyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mytest.R

class ModelAdapter() :RecyclerView.Adapter<ModelAdapter.ModelHolder>() {
    val list = Data().createList()
    class ModelHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_item, parent, false)
        return ModelHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ModelHolder, position: Int) {
        val item = list[position]
        holder.textView.text = item.number
    }

    override fun getItemCount(): Int {
        return list.size
    }
}