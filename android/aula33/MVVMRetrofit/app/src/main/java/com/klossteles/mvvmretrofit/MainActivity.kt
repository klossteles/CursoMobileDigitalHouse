package com.klossteles.mvvmretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.klossteles.mvvmretrofit.list.view.ListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, ListFragment())
            .commit()
    }
}