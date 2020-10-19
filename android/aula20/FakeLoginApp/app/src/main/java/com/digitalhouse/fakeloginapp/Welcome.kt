package com.digitalhouse.fakeloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_welcome.*

class Welcome : AppCompatActivity() {
    private val tvName by lazy { findViewById<TextView>(R.id.tvName) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val name = intent.getStringExtra("NAME")
        tvName.text = name
        tvName.visibility = View.VISIBLE


        val contextView = findViewById<View>(R.id.coordinatorLayout)
        btnFloating.setOnClickListener {
            Snackbar.make(contextView, getString(R.string.float_button_clicker), Snackbar.LENGTH_SHORT).show()
            // Respond to FAB click
        }
    }
}