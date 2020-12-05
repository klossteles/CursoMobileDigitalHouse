package com.klossteles.todolist.todo.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.klossteles.todolist.R
import com.klossteles.todolist.todo.entity.TodoEntity

class TodoListViewHolder(_view: View):RecyclerView.ViewHolder(_view) {
    private val _description = _view.findViewById<TextView>(R.id.txtCardDescription)
    private var _id: Int = 0

    fun bind(todoEntity: TodoEntity) {
        _description.text = todoEntity.description
        _id = todoEntity.id
    }
}