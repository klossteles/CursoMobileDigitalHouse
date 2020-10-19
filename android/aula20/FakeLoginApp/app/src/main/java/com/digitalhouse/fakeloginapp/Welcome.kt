package com.digitalhouse.fakeloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class Welcome : AppCompatActivity() {
    private val tvName by lazy { findViewById<TextView>(R.id.tvName) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val name = intent.getStringExtra("NAME")
        tvName.text = name
        tvName.visibility = View.VISIBLE
    }
}