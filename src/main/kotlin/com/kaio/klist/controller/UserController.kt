package com.kaio.klist.controller

import com.kaio.klist.dto.UserDTO
import com.kaio.klist.dto.UserUpdateRequest
import com.kaio.klist.dto.toDTO
import com.kaio.klist.dto.toEntity
import com.kaio.klist.service.UserService
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.net.URI

@RestController
@RequestMapping("/user")
class UserController(val service: UserService) {

    @PostMapping
    fun createUser(@RequestBody userDTO: UserDTO) = service.createUser(userDTO.toEntity())

    @PostMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody userUpdate: UserUpdateRequest) =
        ResponseEntity.ok(service.updateUser(id, userUpdate.toEntity(id)).toDTO())

    @GetMapping("/info/{id}")
    fun findUser(@PathVariable id: Long) = service.findUser(id)

    @GetMapping
    fun findUserPhoto(@RequestParam id: Long): ResponseEntity<ByteArray> {
        return try {
            val user = service.findUser(id)
            return ResponseEntity.ok().contentType(MediaType.parseMediaType(MediaType.IMAGE_JPEG_VALUE))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"${System.currentTimeMillis()}\"")
                .body(user.photo)
        } catch (error: NoSuchElementException) {
            ResponseEntity.notFound().build()
        }
    }

    @PatchMapping("/photo/{id}", consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun updatePhoto(@PathVariable id: Long, photo: MultipartFile): ResponseEntity<Any> {
        return try {
            service.updatePhoto(id, photo)
            ResponseEntity.created(URI("/user/photo/$id")).build()
        } catch (error: NoSuchElementException) {
            ResponseEntity.notFound().build()
        }
    }
}