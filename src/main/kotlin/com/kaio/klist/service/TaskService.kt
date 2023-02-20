package com.kaio.klist.service

import com.kaio.klist.dto.TaskDTO
import com.kaio.klist.dto.toDTO
import com.kaio.klist.dto.toEntity
import com.kaio.klist.repository.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskService(val db: TaskRepository, val userService: UserService, val notificationService: NotificationService) {
    fun createTask(task: TaskDTO) {
        val user = userService.findUser(task.user!!)
        val task = db.save(task.toEntity(user))
        notificationService.createNotification(task)
    }

    fun getTasksFromUser(id: Long): List<TaskDTO?> {
    val tasks = db.findAllTasksFromUser(id)
    return tasks.map { it.toDTO() }
    }

}
