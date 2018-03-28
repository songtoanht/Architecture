package com.toan.myapplication.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.EditText
import android.widget.TextView
import com.toan.myapplication.R
import com.toan.myapplication.db.StudentDatabase
import com.toan.myapplication.model.Student

class StudentActivity : AppCompatActivity() {
    lateinit var studentDatabase: StudentDatabase
    lateinit var recyclerView: RecyclerView
    private lateinit var students: ArrayList<Student>
    lateinit var adapter: StudentAdapter
    lateinit var edtName: EditText
    lateinit var edtAge: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        studentDatabase = StudentDatabase.getInstance(this)
        students = ArrayList()

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = StudentAdapter(students)
        recyclerView.adapter = adapter

        edtName = findViewById(R.id.edtName)
        edtAge = findViewById(R.id.edtAge)

        findViewById<TextView>(R.id.btnInsert).setOnClickListener {
            val name = edtName.text.toString()
            val age = edtAge.text.toString()

            val student = Student()
            student.name = name
            student.age = age.toInt()

            studentDatabase.studentDao().insertData(student)
            students.add(student)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onStart() {
        super.onStart()
        students.clear()
        students.addAll(studentDatabase.studentDao().getListStudents())
        adapter.notifyDataSetChanged()
    }
}