package com.example.bitfit1

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo


@Entity(tableName = "exercise_table")
data class SqlExercise(
    @PrimaryKey(autoGenerate = true) val id: Long = 0, // Don't really need to worry of id
    @ColumnInfo(name = "exerciseDone") val exerciseComplete: String?,
    @ColumnInfo(name = "exerciseTime") val exerciseTiming: String?
)
