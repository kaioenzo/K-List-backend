package com.kaio.klist.Service

import com.kaio.klist.entity.User
import com.kaio.klist.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService ( val db : UserRepository ) {
    fun createUser(user: User) = db.save(user)

    fun updateUser(id: Long, user: User): User{
        return db.save(user)
    }

    fun findUser(id: Long): User = db.findById(id).get()
}