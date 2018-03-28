package com.toan.myapplication.ui

import com.toan.myapplication.model.Student

class StudentPresenter constructor(val view: StudentContract.View) : StudentContract.Presenter {

    override fun loadData() {
//        StudentDatabase.getInstance()
    }

    override fun insertStudent(student: Student) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun start() {
        loadData()
    }

    override fun stop() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}