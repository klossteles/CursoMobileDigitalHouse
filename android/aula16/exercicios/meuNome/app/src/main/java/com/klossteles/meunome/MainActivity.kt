package com.klossteles.meunome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val etInputName by lazy { findViewById<EditText>(R.id.etName) }
    private val btnShowName by lazy { findViewById<Button>(R.id.btnShowName) }
    private val tvName by lazy { findViewById<TextView>(R.id.tvName) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showView()
    }

    private fun showView() {
        btnShowName.setOnClickListener {
            val name = etInputName.text.toString()
            if (name.isNotEmpty()) {
                tvName.text = getString(R.string.myNameIs, name)
                tvName.visibility = View.VISIBLE
            } else {
                etInputName.error = getString(R.string.inputName)
            }
        }
    }
}