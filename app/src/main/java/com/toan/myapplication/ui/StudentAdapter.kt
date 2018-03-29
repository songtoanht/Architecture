package com.toan.myapplication.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.toan.myapplication.R
import com.toan.myapplication.model.Student

class StudentAdapter(var students: List<Student>, private val listener: View.OnClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false) as View
        return ItemViewHolder(v, listener)
    }

    override fun getItemCount(): Int {
        return students.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val h = holder as ItemViewHolder
        h.ivDelete.tag = position
        h.setData(students[position])
    }

    class ItemViewHolder(item: View, listener: View.OnClickListener) : RecyclerView.ViewHolder(item) {
        var tvName: TextView = item.findViewById(R.id.tvName)
        var ivDelete: ImageView = item.findViewById(R.id.ivDelete)

        init {
            ivDelete.setOnClickListener {
                listener?.onClick(ivDelete)
            }
        }

        fun setData(student: Student) {
            tvName.text = student.name
        }
    }

}