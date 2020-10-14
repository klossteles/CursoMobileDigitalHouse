package com.klossteles.aula19

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_new_activity.*

class NewActivity : AppCompatActivity() {
    private val tvName by lazy { findViewById<TextView>(R.id.tvName) }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_activity)

        val extras = intent.extras
        val name = extras?.getString("NAME")
        val idade = intent.getIntExtra("IDADE", 0).toInt()

        tvName.text = "$name $idade"
    }
}