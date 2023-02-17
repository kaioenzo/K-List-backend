package com.kaio.klist.service

import com.kaio.klist.dto.TaskDTO
import com.kaio.klist.dto.toEntity
import com.kaio.klist.repository.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskService(val db: TaskRepository, val userService: UserService) {
    fun createTask(task: TaskDTO) {
        val user = userService.findUser(task.user)

        db.save(task.toEntity(user))
    }

}
