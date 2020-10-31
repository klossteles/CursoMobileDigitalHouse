package com.klossteles.todolist.todolist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.klossteles.todolist.task.model.TaskModel
import com.klossteles.todolist.task.repository.TaskRepository

class TodoListViewModel(
    private val repository: TaskRepository
):ViewModel() {
    val tasks = MutableLiveData<List<TaskModel>>()

    fun getList() {
        repository.getList {
            tasks.value = it
        }
    }

    class ListTodoListViewModelFactory(
        private val repository: TaskRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return TodoListViewModel(repository) as T
        }
    }
}