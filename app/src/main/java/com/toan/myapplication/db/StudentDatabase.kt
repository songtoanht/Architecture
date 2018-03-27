package com.toan.myapplication.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.toan.myapplication.model.Student


@Database(entities = [Student::class], version = 1)
abstract class StudentDatabase : RoomDatabase() {
    companion object {
        private lateinit var INSTANCE: StudentDatabase

        fun getInstance(context: Context): StudentDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                        StudentDatabase::class.java, "Sample.db")
                        .build()
            }
            return INSTANCE
        }
    }

    abstract fun studentDao(): StudentDAO


}