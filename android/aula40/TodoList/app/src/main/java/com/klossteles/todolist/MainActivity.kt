package com.klossteles.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.klossteles.todolist.todo.view.TodoListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, TodoListFragment())
            .commit()
    }
}