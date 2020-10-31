package com.klossteles.todolist.task.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.klossteles.todolist.task.model.TaskModel
import com.klossteles.todolist.task.repository.TaskRepository

class TaskViewModel(
    private val repository: TaskRepository
):ViewModel() {
    fun deleteTask(task: TaskModel) {
        repository.deleteTask(task)
    }

    class TaskViewModelFactory(
        private val repository: TaskRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return TaskViewModel(repository) as T
        }
    }
}