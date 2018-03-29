package com.toan.myapplication.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "student")
data class Student(

        @ColumnInfo(name = "name")
        var name: String,
        @ColumnInfo(name = "age")
        var age: Int,
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0
        )