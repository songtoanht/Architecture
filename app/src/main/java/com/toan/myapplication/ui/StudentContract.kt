package com.toan.myapplication.ui

import com.toan.myapplication.BasePreseter
import com.toan.myapplication.BaseView
import com.toan.myapplication.model.Student

interface StudentContract {

    interface View : BaseView<Presenter> {
        fun showListStudent(students: List<Student>)
    }

    interface Presenter : BasePreseter {
        fun loadData()

        fun insertStudent(student: Student)
    }
}