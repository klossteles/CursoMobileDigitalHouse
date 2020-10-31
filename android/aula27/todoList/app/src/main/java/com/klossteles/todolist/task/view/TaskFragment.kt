package com.klossteles.todolist.task.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.klossteles.todolist.R
import com.klossteles.todolist.task.repository.TaskRepository
import com.klossteles.todolist.task.viewmodel.TaskViewModel

class TaskFragment : Fragment() {
    lateinit var minhaView: View
    lateinit var viewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            TaskViewModel.TaskViewModelFactory(TaskRepository())
        ).get(TaskViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        minhaView = inflater.inflate(R.layout.fragment_task, container, false)
        // Inflate the layout for this fragment
        return minhaView
    }
}