package com.klossteles.todolist.todolist.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputLayout
import com.klossteles.todolist.R
import com.klossteles.todolist.task.model.TaskModel

class TodoListAdapter(private val dataset: List<TaskModel>, private val listener: (TaskModel) -> Unit):
    RecyclerView.Adapter<TodoListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_task, parent, false)
//        view.findViewById<Button>(R.id.btnDelete).setOnClickListener {
//            val taskDesc = it.findViewById<TextInputLayout>(R.id.txtTaskDesc)
//            val ckTaskStatus = it.findViewById<CheckBox>(R.id.chkTaskStatus)
//         TODO(): chamar TaskViewModel para realizar exclusão
//
//        }
        return TodoListViewHolder(view)
    }

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        val item = dataset[position]
        holder.bind(item)

//        holder.itemView.setOnClickListener { item }
    }
}