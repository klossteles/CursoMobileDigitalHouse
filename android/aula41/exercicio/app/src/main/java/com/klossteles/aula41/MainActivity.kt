package com.klossteles.aula41

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    companion object {
        const val AULA_41 = "Aula41"
        const val KEEP_LOGGED = "KeepLogged"
    }
}