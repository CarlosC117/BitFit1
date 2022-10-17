package com.example.bitfit1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SqlExercise::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun ExerciseDao(): ExerciseDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context) : AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDataBase(context).also {INSTANCE = it}
            }

        private fun buildDataBase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "Exercises-db"
            ).build()
    }
}