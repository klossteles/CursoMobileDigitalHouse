package com.klossteles.todolist.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.klossteles.todolist.todo.dao.TodoDao
import com.klossteles.todolist.todo.entity.TodoEntity

@Database(
    entities = [TodoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
    abstract  fun todoDao(): TodoDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        // Singleton
        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "todoListDb"
                ).build()
            }

            return INSTANCE!!
        }
    }
}