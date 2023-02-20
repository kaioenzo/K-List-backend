package com.kaio.klist.dto

import com.kaio.klist.entity.Task
import com.kaio.klist.entity.User
import java.time.LocalDateTime

data class TaskDTO (
    var id: Long?,
    var title: String?,
    var description: String?,
    var done: Boolean?,
    var notification: Boolean?,
    var date: LocalDateTime?,
    var user: Long?,
    var tokenNotification: String? = null,
    )

fun TaskDTO.toEntity(user: User) = Task(
    id = id,
    title = title,
    description = description,
    done = done,
    notification = notification,
    date = date,
    user = user,
    isNotificated = false,
    )
fun Task.toDTO() = TaskDTO(
    title = title,
    description = description,
    done = done,
    date = date,
    notification = notification,
    user = user?.id,
    id = id,
)