package com.example.myapplication


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class AboutActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        findViewById<Button>(R.id.back_button)
        findViewById<View>(R.id.back_button).setOnClickListener { finish() }
    }

    override fun onClick(view: View) {}
}