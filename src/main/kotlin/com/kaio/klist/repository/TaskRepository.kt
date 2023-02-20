package com.kaio.klist.repository

import com.kaio.klist.entity.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TaskRepository : JpaRepository<Task, Long>{
    @Query("SELECT t from Task t WHERE t.user.id = :id")
    fun findAllTasksFromUser(id: Long): List<Task>
}