package com.kaio.klist.controller

import com.kaio.klist.Service.UserService
import com.kaio.klist.dto.UserDTO
import com.kaio.klist.dto.UserUpdateRequest
import com.kaio.klist.dto.toDTO
import com.kaio.klist.dto.toEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(val service: UserService) {

    @PostMapping
    fun createUser(@RequestBody userDTO: UserDTO) = service.createUser(userDTO.toEntity())

    @PostMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody userUpdate: UserUpdateRequest) =
        ResponseEntity.ok(service.updateUser(id, userUpdate.toEntity(id)).toDTO())
}