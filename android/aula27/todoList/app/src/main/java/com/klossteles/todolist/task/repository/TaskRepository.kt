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

    fun addTask(task: TaskModel): String {
        for (t in tasks) {
            if (t.description.equals(task.description)) {
                return "Task cannot have same description"
            }
        }
        tasks.add(task)
        return ""
    }

    fun deleteTask(task: TaskModel): Boolean {
        return tasks.remove(task)
    }

    fun updateTaskStatus(task: TaskModel, status: Boolean) {
        for (t in tasks) {
            if (t.equals(task)) {
                t.status = status
                break
            }
        }
    }
}
