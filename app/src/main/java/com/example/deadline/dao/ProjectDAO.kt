package com.example.deadline.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.deadline.entities.Project

@Dao
interface ProjectDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProject(project: Project)

    @Query("SELECT * FROM projects WHERE userId = :userId")
    suspend fun getProjectsByUserId(userId: Int): List<Project>

    @Query("DELETE FROM projects WHERE projectId = :projectId")
    suspend fun deleteProject(projectId: Int)
}
