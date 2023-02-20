package com.kaio.klist.service

import com.kaio.klist.entity.User
import com.kaio.klist.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class UserService ( val db : UserRepository ) {
    fun createUser(user: User) = db.save(user)

    fun updateUser(id: Long, user: User): User{
        return db.save(user)
    }
    fun findUser(id: Long): User = db.findUserWithTasks(id)
    fun updatePhoto(id: Long, photo: MultipartFile): Any {
        val user = db.findById(id).get()
        user.photo = photo.bytes
        db.save(user)
        return user
    }
}