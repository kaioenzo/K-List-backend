package com.kaio.klist.dto

import com.kaio.klist.entity.Task
import com.kaio.klist.entity.User
import java.util.Base64

data class UserDTO(
    var name: String?,
    var email: String?,
    var password: String?,
    var tasks: List<Task>?,
    var photo: String?,
)

fun UserDTO.toEntity() = User(name = name, email = email, password = password, tasks = emptySet())

data class UserUpdateRequest(
    var name: String,
    var email: String,
    var password: String,
)

fun UserUpdateRequest.toEntity(id: Long) = User(
    id = id,
    name = name,
    email = email,
    password = password,
    tasks = null
)

fun User.toDTO() = UserDTO(name = name, email = email, password = password, tasks = tasks?.toList(), photo = photo?.let { Base64.getEncoder().encodeToString(it) })
