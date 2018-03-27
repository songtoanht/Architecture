package com.toan.myapplication.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "student")
class Student {
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int = 1

    @ColumnInfo(name = "name")
    var name: String = ""

    @ColumnInfo(name = "age")
    var age: Int = 0
}