package com.example.bitfit1

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MainAdapter (private val context: Context, private val exercises: MutableList<Int>):
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    // set variables
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        // Removed the override cause no overriding has happened
        fun onClick(v: View?) {
            val exercise = exercises[0]  // Adapter
        }
    }

    // set the view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.main_list, parent, false)
        return ViewHolder(view)
    }

    // not done set variables to one another
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        println("Hi")
    }

    override fun getItemCount(): Int {
        return exercises.size
    }

}