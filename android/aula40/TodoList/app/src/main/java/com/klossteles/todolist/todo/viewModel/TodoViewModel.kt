package com.klossteles.todolist.todo.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.klossteles.todolist.todo.entity.TodoEntity
import com.klossteles.todolist.todo.repository.TodoRepository
import kotlinx.coroutines.Dispatchers

class TodoViewModel(private val _repository: TodoRepository): ViewModel() {
    private lateinit var _todos: List<TodoEntity>
    fun addTodo(description: String) = liveData(Dispatchers.IO) {
        val todo = TodoEntity(0, description)
        _repository.addTodo(todo)
        emit(todo)
    }

    fun getTodos() = liveData(Dispatchers.IO) {
        _todos = _repository.getTodos()
        emit(_todos)
    }

    fun deleteTodo(description: String) = liveData(Dispatchers.IO) {
        for (todo in _todos) {
            if (todo.description == description) {
                _repository.deleteTodo(todo)
                break
            }
        }
        emit(true)
    }

    class TodoViewModelFactory(private val _repository: TodoRepository): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return TodoViewModel(_repository) as T
        }
    }
}