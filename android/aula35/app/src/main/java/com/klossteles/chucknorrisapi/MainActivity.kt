package com.klossteles.chucknorrisapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.klossteles.chucknorrisapi.category.view.CategoryListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}