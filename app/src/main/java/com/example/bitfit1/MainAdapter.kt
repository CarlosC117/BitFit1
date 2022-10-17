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

class MainAdapter (private val context: Context, private val exercises: MutableList<ExerciseData>):
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    // set variables
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var nameOfExercise: TextView = itemView.findViewById(R.id.exerciseTvName)
        var timeOfExercise: TextView = itemView.findViewById(R.id.userTime)

    }

    // not done set variables to one another
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val exercise = exercises[position]
        holder.nameOfExercise.text = exercise.exerciseName
        holder.timeOfExercise.text = exercise.exerciseTime
    }

    // set the view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.main_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return exercises.size
    }

}