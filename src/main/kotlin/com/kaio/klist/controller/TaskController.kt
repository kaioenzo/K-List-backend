package com.kaio.klist.controller

import com.kaio.klist.service.TaskService
import com.kaio.klist.dto.TaskDTO
import com.kaio.klist.entity.Task
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tasks")
class TaskController(val service: TaskService) {

    @PostMapping
    fun createTask(@RequestBody task: TaskDTO) = service.createTask(task)

    @GetMapping("userTask/{userId}")
    fun getTasks(@PathVariable userId: Long ) = ResponseEntity.ok().body(service.getTasksFromUser(userId))

    @GetMapping("userTask/{userId}/{taskId}")
    fun getTask(@PathVariable userId: Long, @PathVariable taskId: Long): ResponseEntity<Task> {
        val task = service.getTaskFromUser(userId, taskId)
        return ResponseEntity.ok().body(task)
    }
    @DeleteMapping("userTask/{userId}/{taskId}")
    fun deleteTask(@PathVariable userId: Long, @PathVariable taskId: Long): ResponseEntity<Any> {
        service.deleteTask(userId, taskId)
        return ResponseEntity.noContent().build()
    }
}