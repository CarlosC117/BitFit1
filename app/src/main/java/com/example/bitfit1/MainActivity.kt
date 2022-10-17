package com.example.bitfit1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var exerciseAddButton: Button
    private lateinit var exerciseRecyclerView: RecyclerView
    private val exercises = mutableListOf<ExerciseData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set recycler view and adapter
        exerciseRecyclerView = findViewById(R.id.recyclerMain)

        val exerciseAdapter = MainAdapter(this, exercises)
        exerciseRecyclerView.adapter = exerciseAdapter
        exerciseRecyclerView.layoutManager = LinearLayoutManager(this).also {
            val dividerItemDec = DividerItemDecoration(this, it.orientation)
            exerciseRecyclerView.addItemDecoration(dividerItemDec)
        }

        exerciseAddButton = findViewById(R.id.exerciseButton)

        val exerciseMain = intent.getSerializableExtra("Exercise!") as ExerciseData?

        lifecycleScope.launch {
            (application as ExerciseApplication).db. ExerciseDao().getAll().collect { databaseList ->
                databaseList.map { entity ->
                    ExerciseData(
                        entity.exerciseComplete,
                        entity.exerciseTiming
                    )
                }.also { mappedList ->
                    exercises.clear()
                    exercises.addAll(mappedList)
                    exerciseAdapter.notifyItemRangeInserted(0, exercises.size)
                }

            }
        }

        if(exerciseMain != null) {
            lifecycleScope.launch(IO) {
                (application as ExerciseApplication).db.ExerciseDao().insert(
                    SqlExercise(
                        exerciseComplete = exerciseMain.exerciseName,
                        exerciseTiming = exerciseMain.exerciseTime
                    )
                )
            }

        }

        // When user taps button to add it opens other activity.
        exerciseAddButton.setOnClickListener {
            val intentMain = Intent(this, ExerciseActivity::class.java)
            this.startActivity(intentMain)
        }
    }

}