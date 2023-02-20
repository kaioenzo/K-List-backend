package com.kaio.klist.repository

import com.kaio.klist.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long>{
    @Query("SELECT u FROM user u LEFT JOIN FETCH u.tasks WHERE u.id = :id")
    fun findUserWithTasks(id: Long): User
}