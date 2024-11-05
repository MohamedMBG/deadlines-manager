package com.example.deadline.data

import com.example.deadline.dao.ProjectDao
import com.example.deadline.dao.UserDao
import com.example.deadline.entities.Project
import com.example.deadline.entities.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DeadlineRepository(private val projectDao: ProjectDao , private val userDao: UserDao) {

    // Function to insert a new project
    suspend fun insertProject(project: Project) {
        withContext(Dispatchers.IO) {
            projectDao.insertProject(project)
        }
    }

    // Function to get all projects by user ID
    suspend fun getProjectsByUserId(userId: Int): List<Project> {
        return withContext(Dispatchers.IO) {
            projectDao.getProjectsByUserId(userId)
        }
    }

    // Function to insert a new user
    suspend fun insertUser(user: User) {
        withContext(Dispatchers.IO) {
            userDao.insertUser(user)
        }
    }

    // Function to get a user by ID
    suspend fun getUserById(userId: Int): User? {
        return withContext(Dispatchers.IO) {
            userDao.getUserById(userId)
        }
    }
}