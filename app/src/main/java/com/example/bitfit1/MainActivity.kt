package com.example.bitfit1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var exerciseAddButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        exerciseAddButton = findViewById(R.id.exerciseButton)

        // example of how to use the data
//        val color = intent.getSerializableExtra("Exercise!") as ExerciseData?
//
//        if(color?.exerciseName != null && color.exerciseTime != null) {
//            exerciseAddButton.text = color.exerciseName
//        }

        // When user taps button to add it opens other activity.
        exerciseAddButton.setOnClickListener {
            val intentMain = Intent(this, ExerciseActivity::class.java)
            this.startActivity(intentMain)
        }
    }

}