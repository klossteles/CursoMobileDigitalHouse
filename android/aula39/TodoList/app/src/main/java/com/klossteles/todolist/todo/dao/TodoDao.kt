package com.klossteles.todolist.todo.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.klossteles.todolist.todo.entity.TodoEntity

@Dao
interface TodoDao {
    @Insert
    suspend fun addTodo(todo: TodoEntity)

    @Query("SELECT * FROM TODO")
    suspend fun getTodos(): List<TodoEntity>

    @Delete
    suspend fun deleteTodo(todo: TodoEntity)
}