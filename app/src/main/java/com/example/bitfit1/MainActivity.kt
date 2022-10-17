package com.example.bitfit1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var exerciseAddButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        exerciseAddButton = findViewById(R.id.exerciseButton)

        // When user taps button to add it opens other activity.
        exerciseAddButton.setOnClickListener {
            val intentMain = Intent(this, ExerciseActivity::class.java)
            this.startActivity(intentMain)
        }
    }

}