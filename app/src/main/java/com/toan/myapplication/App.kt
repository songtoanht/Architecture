package com.toan.myapplication

import android.app.Application
import com.toan.myapplication.db.StudentDatabase

class App : Application() {


    override fun onCreate() {
        super.onCreate()
        StudentDatabase.getInstance(this)

    }
}