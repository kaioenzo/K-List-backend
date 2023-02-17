package com.kaio.klist.controller

import com.kaio.klist.service.TaskService
import com.kaio.klist.dto.TaskDTO
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tasks")
class TaskController(val service: TaskService) {

    @PostMapping
    fun createTask(@RequestBody task: TaskDTO) = service.createTask(task);
}