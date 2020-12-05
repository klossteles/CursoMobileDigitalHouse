package com.klossteles.aula39.dp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.klossteles.aula39.card.dao.CardDao
import com.klossteles.aula39.card.entity.CardEntity

@Database(
    entities = [CardEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
    abstract  fun cardDao(): CardDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        // Singleton
        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "pagbem"
                ).build()
            }

            return INSTANCE!!
        }
    }
}