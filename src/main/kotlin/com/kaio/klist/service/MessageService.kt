package com.kaio.klist.service

import com.kaio.klist.entity.Message
import com.kaio.klist.repository.MessageRepository
import org.springframework.stereotype.Service

@Service
class MessageService (val db : MessageRepository) {
    fun getMessages(): List<Message> = db.findAllMessages()

    fun saveMessage(message: Message) = db.save(message)
}