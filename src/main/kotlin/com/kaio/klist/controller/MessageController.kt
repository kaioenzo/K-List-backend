package com.kaio.klist.controller

import com.kaio.klist.Service.MessageService
import com.kaio.klist.entity.Message
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/messages")
class MessageController (val service: MessageService){

    @GetMapping
    fun getMessagges() = service.getMessages()

    @PostMapping
    fun saveMessage(@RequestBody message: Message) = service.saveMessage(message)
}