package com.klossteles.todolist.todolist.view

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.klossteles.todolist.R
import com.klossteles.todolist.task.model.TaskModel
import com.klossteles.todolist.todolist.viewmodel.TodoListViewModel

class TodoListAdapter(private val dataset: List<TaskModel>, private val viewModel: TodoListViewModel, private val listener: (TaskModel) -> Unit):
    RecyclerView.Adapter<TodoListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_task, parent, false)
        onDeleteTask(view)
        onCheckChanged(view)
        return TodoListViewHolder(view)
    }

    private fun onCheckChanged(view: View) {
        view.findViewById<CheckBox>(R.id.chkTaskStatus).setOnCheckedChangeListener { _, isChecked ->
            val taskDesc = view.findViewById<TextView>(R.id.txtTaskDesc)
            if (isChecked) {
                taskDesc.apply {
                    paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                }
            } else {
                taskDesc.apply {
                    paintFlags = 0
                }
            }
            viewModel.updateTaskStatus(TaskModel(taskDesc.text.toString(), !isChecked), isChecked)
            notifyDataSetChanged()
        }
    }

    private fun onDeleteTask(view: View) {
        view.findViewById<Button>(R.id.btnDelete).setOnClickListener {
            val taskDesc = view.findViewById<TextView>(R.id.txtTaskDesc)
            val ckTaskStatus = view.findViewById<CheckBox>(R.id.chkTaskStatus)
            if (viewModel.deleteTask(TaskModel(taskDesc.text.toString(), ckTaskStatus.isChecked))) {
                notifyDataSetChanged()
            }
        }
    }

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        val item = dataset[position]
        holder.bind(item)
//        holder.itemView.setOnClickListener { item }
    }
}