package com.toan.myapplication.db

import com.toan.myapplication.model.Student

interface StudentSource {
    fun getListStudent(): List<Student>

    fun insertStudent(data: Student)

    fun updateStudent(data: Student)

    fun deleteStudent(data: Student)
}