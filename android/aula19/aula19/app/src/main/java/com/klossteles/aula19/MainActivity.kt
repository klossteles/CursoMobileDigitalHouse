package com.klossteles.aula19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val btnClickHere by lazy { findViewById<Button>(R.id.btnClickHere) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showNewActivity()
    }

    private fun showNewActivity() {
        btnClickHere.setOnClickListener {
            val intent = Intent(this, NewActivity::class.java)
            intent.putExtra("NAME", "Lucas")
            intent.putExtra("IDADE", 27)

            Toast.makeText(this, "Mudando para tela secundária", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }
}