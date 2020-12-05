package com.klossteles.todolist.todo.repository

import com.klossteles.todolist.todo.dao.TodoDao
import com.klossteles.todolist.todo.entity.TodoEntity

class TodoRepository(private val _todoDao: TodoDao) {
    suspend fun addTodo(todo: TodoEntity) = _todoDao.addTodo(todo)
    suspend fun getTodos() = _todoDao.getTodos()
    suspend fun deleteTodo(todo: TodoEntity)= _todoDao.deleteTodo(todo)
}