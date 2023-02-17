package com.kaio.klist.repository

import com.kaio.klist.entity.Message
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface MessageRepository : JpaRepository<Message, Long> {
    @Query("SELECT * FROM message", nativeQuery = true)
    fun findAllMessages(): List<Message>
}