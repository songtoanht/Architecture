package com.toan.myapplication.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.toan.myapplication.R
import com.toan.myapplication.model.Student

class StudentAdapter(var students: List<Student>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false) as View
        return ItemViewHolder(v)
    }

    override fun getItemCount(): Int {
        return students.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val h = holder as ItemViewHolder
        h.setData(students[position])
    }

    class ItemViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var tvName: TextView = item.findViewById(R.id.tvName)

        fun setData(student: Student) {
            tvName.text = student.name
        }

    }

}