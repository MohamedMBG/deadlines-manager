package com.example.deadline.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.deadline.entities.Project
import com.example.deadline.entities.User
import android.content.Context
import com.example.deadline.dao.ProjectDao
import com.example.deadline.dao.UserDao

@Database(entities = [User::class, Project::class], version = 1)
abstract class DeadlineDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun projectDao(): ProjectDao

    companion object {
        @Volatile
        private var INSTANCE: DeadlineDatabase? = null

        fun getDatabase(context: Context): DeadlineDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DeadlineDatabase::class.java,
                    "deadline_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
