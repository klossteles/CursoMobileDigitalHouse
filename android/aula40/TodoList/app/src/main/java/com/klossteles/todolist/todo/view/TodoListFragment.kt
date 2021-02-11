package com.klossteles.todolist.todo.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.klossteles.todolist.R
import com.klossteles.todolist.db.AppDatabase
import com.klossteles.todolist.todo.entity.TodoEntity
import com.klossteles.todolist.todo.repository.TodoRepository
import com.klossteles.todolist.todo.viewModel.TodoViewModel

class TodoListFragment : Fragment() {
    private lateinit var _view: View
    private lateinit var _viewModel: TodoViewModel
    private lateinit var _listAdapter: TodoListAdapter
    private lateinit var _recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_todo_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _view = view
        _viewModel = ViewModelProvider(
            this,
            TodoViewModel.TodoViewModelFactory(TodoRepository(AppDatabase.getDatabase(_view.context).todoDao()))
        ).get(TodoViewModel::class.java)


        _recyclerView = _view.findViewById(R.id.rvTodoList)
        val manager = LinearLayoutManager(_view.context)
        _listAdapter = TodoListAdapter(_viewModel) { }

        _recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = manager
            adapter = _listAdapter
        }

        bindEvents()
        getTodoList()
    }

    private fun bindEvents() {
        _view.findViewById<Button>(R.id.btnAdd).setOnClickListener {
            val description = _view.findViewById<TextInputEditText>(R.id.edtDescription)
            _viewModel.addTodo(description.text.toString())
                .observe(viewLifecycleOwner, {
                    _listAdapter.addTodo(it)
                })
        }
    }

    private fun getTodoList() {
        _viewModel.getTodos().observe(viewLifecycleOwner, {
            _listAdapter.addTodos(it)
        })
    }
}