package com.klossteles.todolist.todo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.klossteles.todolist.R
import com.klossteles.todolist.todo.viewModel.TodoViewModel

class TodoListItemFragment : Fragment() {
    private lateinit var _viewModel: TodoViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_todo_list_item, container, false)
    }
}