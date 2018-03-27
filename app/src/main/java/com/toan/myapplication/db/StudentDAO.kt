package com.toan.myapplication.db

import android.arch.persistence.room.*
import com.toan.myapplication.model.Student

@Dao
interface StudentDAO {
    @Query("SELECT * FROM student")
    fun getListStudents(): List<Student>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(data: Student)

    @Delete
    fun deleteStudent(data: Student)
}