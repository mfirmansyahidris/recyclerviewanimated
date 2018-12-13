package com.dev.fi.recyclerviewanimated

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class Adapter(private val context: Context, private val dataSet: MutableList<String>, private val listener: (String) -> Unit)
    : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.adapter, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(dataSet[position], listener)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    fun remove(position: Int) {
        dataSet.removeAt(position)
        notifyItemRemoved(position)
    }

    fun remove(element: String) {
        val position = dataSet.indexOf(element)
        dataSet.remove(element)
        notifyItemRemoved(position)
    }

    fun add(text: String, position: Int) {
        dataSet.add(position, text)
        notifyItemInserted(position)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var text: TextView = itemView.findViewById<View>(R.id.text) as TextView

        fun bindItem(items: String, listener: (String) -> Unit) {
            text.text = items
            itemView.setOnClickListener {
                listener(items)
            }
        }
    }
}