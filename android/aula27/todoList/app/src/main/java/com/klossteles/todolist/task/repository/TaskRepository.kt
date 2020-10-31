package com.klossteles.todolist.task.repository

import com.klossteles.todolist.task.model.TaskModel

class TaskRepository() {
    var tasks = mutableListOf<TaskModel>(TaskModel("Revisar conteúdo", false))

    fun getList(callback: (tasks: List<TaskModel>) -> Unit) {
        callback.invoke(getTasksList())
    }

    fun getTasksList(): MutableList<TaskModel> {
        return tasks
    }

    fun addTask(task: TaskModel) {
        tasks.add(task)
    }
}
