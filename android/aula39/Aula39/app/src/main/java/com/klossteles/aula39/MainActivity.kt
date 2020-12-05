package com.klossteles.aula39

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.klossteles.aula39.card.view.CardFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, CardFragment())
            .commit()
    }
}