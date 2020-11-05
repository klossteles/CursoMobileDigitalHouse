package com.klossteles.todolist.task.model

class TaskModel(var description: String, var status:Boolean = false){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TaskModel

        if (description != other.description) return false
        if (status != other.status) return false

        return true
    }

    override fun hashCode(): Int {
        var result = description.hashCode()
        result = 31 * result + status.hashCode()
        return result
    }
}