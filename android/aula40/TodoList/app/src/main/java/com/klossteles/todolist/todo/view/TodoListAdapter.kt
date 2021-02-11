package com.klossteles.todolist.todo.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.klossteles.todolist.R
import com.klossteles.todolist.todo.entity.TodoEntity
import com.klossteles.todolist.todo.viewModel.TodoViewModel

class TodoListAdapter(private val _viewModel: TodoViewModel, private val listener: (TodoEntity) -> Unit):
    RecyclerView.Adapter<TodoListViewHolder>() {
    private val _todos: MutableList<TodoEntity> = mutableListOf()

    fun addTodo(todo: TodoEntity) {
        _todos.add(todo)
        notifyDataSetChanged()
    }

    fun addTodos(todos: List<TodoEntity>) {
        _todos.addAll(todos)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_todo_list_item, parent, false)
        onDeleteTodo(view)
        return TodoListViewHolder(view)
    }

    private fun onDeleteTodo(view: View) {
        view.findViewById<ImageView>(R.id.imgDelete).setOnClickListener {
            val description = view.findViewById<TextView>(R.id.txtCardDescription).text
            _viewModel.deleteTodo(description.toString())
            notifyDataSetChanged()
        }
    }

    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        val item = _todos[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { listener(item) }
    }

    override fun getItemCount() = _todos.size
}