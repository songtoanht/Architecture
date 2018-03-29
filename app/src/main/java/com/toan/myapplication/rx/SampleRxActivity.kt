package com.toan.myapplication.rx

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.toan.myapplication.R
import io.reactivex.Observable
import io.reactivex.Single

class SampleRxActivity : AppCompatActivity() {
    private lateinit var tvValue: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_rx)

        tvValue = findViewById(R.id.tvValue)

        rxListener()
    }


    private fun rxListener() {
//        var observable: Observable<List<String>> = Observable.just("Hello", "Hello")
        val s = StringBuffer()

        Observable.just("Hello", "T1", "T2")
                .subscribe({ it ->
                    s.append(it)
                }, {
                    s.append(it.localizedMessage)
                }, {
                    tvValue.text = s.toString()
                })

        Single.just("Bongdaso")
                .subscribe({
                    tvValue.text = it
                }, {
                    tvValue.text = it.localizedMessage
                })
    }
}