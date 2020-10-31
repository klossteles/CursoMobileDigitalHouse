package com.klossteles.todolist.todolist.view

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.klossteles.todolist.R
import com.klossteles.todolist.task.model.TaskModel

class TodoListViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
    private val description = view.findViewById<TextView>(R.id.txtTaskDesc)
    private val taskStatus = view.findViewById<CheckBox>(R.id.chkTaskStatus)

    fun bind(taskModel: TaskModel) {
        description.text = taskModel.description
        taskStatus.isChecked = taskModel.status
    }
}