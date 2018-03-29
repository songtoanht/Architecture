package com.toan.myapplication.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.toan.myapplication.Android
import com.toan.myapplication.R
import com.toan.myapplication.db.StudentDatabase
import com.toan.myapplication.model.Student
import io.reactivex.Observable
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import java.io.IOException

class StudentActivity : AppCompatActivity() {
    private lateinit var studentDatabase: StudentDatabase
    private lateinit var recyclerView: RecyclerView
    private lateinit var students: ArrayList<Student>
    private lateinit var adapter: StudentAdapter
    private lateinit var edtName: EditText
    private lateinit var edtAge: EditText
    private var onClickListener = View.OnClickListener {
        val pos = it.tag as Int
        deleteWithThread(students[pos])
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
        recyclerView = findViewById(R.id.recycler)

        studentDatabase = StudentDatabase.getInstance(this)
        students = ArrayList()

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = StudentAdapter(students, onClickListener)
        recyclerView.adapter = adapter

        edtName = findViewById(R.id.edtName)
        edtAge = findViewById(R.id.edtAge)

        findViewById<TextView>(R.id.btnInsert).setOnClickListener {
            val name = edtName.text.toString()
            val age = edtAge.text.toString()

            val student = Student(name, age.toInt())
//            student.name = name
//            student.age = age.toInt()

            insertWithThread(student)


//            studentDatabase.studentDao().insertData(student)
//            students.add(student)
//            adapter.notifyDataSetChanged()
        }

        findViewById<TextView>(R.id.btnShow).setOnClickListener {
            edtName.setText("")
            edtAge.setText("")

            getListStudentWithThread()

//            students.clear()
//            students.addAll(studentDatabase.studentDao().getListStudents())
//            adapter.notifyDataSetChanged()
        }
    }

    override fun onStart() {
        super.onStart()
        getListStudentWithThread()
    }

//    private fun getListStudentWithThread() {
//        launch {
//            students = studentDatabase.studentDao().getListStudents()
//        }(adapter.notifyDataSetChanged())
//    }

    private fun getListStudentWithThread() {
//        return async(CommonPool) {
//            studentDatabase.studentDao().getListStudents()
//        }

        val job = async(CommonPool) {
            studentDatabase.studentDao().getListStudents()
        }

        launch(Android) {
            students.clear()
            try {
                students.addAll(job.await())
                adapter.notifyDataSetChanged()
            } catch (exception: IOException) {
                Toast.makeText(this@StudentActivity, "Phone not connected or service down", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun insertWithThread(student: Student) {
        launch {
            studentDatabase.studentDao().insertData(student)
        }

        students.add(student)
        adapter.notifyDataSetChanged()
    }

    private fun deleteWithThread(student: Student) {
        launch {
            studentDatabase.studentDao().deleteStudent(student)
        }

        students.remove(student)
        adapter.notifyDataSetChanged()
    }
}
