package com.kaio.klist.service

import com.kaio.klist.entity.Notification
import com.kaio.klist.entity.Task
import com.kaio.klist.repository.NotificationRepository
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.lang.Exception
import java.time.LocalDateTime

@Service
class NotificationService(val db: NotificationRepository) {

    @Async
    @Scheduled(fixedDelay = 50000)
    fun sendNotification() {
        var count = 0
        var total = 0
        val startedTime = System.currentTimeMillis()
        println(
            "start sending notification..."
        )
        db.findAll().forEach {
            if (!it.isSend && LocalDateTime.now().isAfter(it.task?.date!!)){
                count++
                try{
                    Thread.sleep(2000)
                    println(
                        "sending notification... of: " + it.task.title
                    )
                    it.isSend = true
                    it.task.isNotificated = true
                } catch (ignored: Exception){
                    println(ignored.message)
                }
                db.save(it)
                total++
            }
        }
        println("finish sending notification...")
        println("delivered notifications: $count of $total with sucess")
        println("time of process: ${System.currentTimeMillis() - startedTime} ms")
    }

    fun createNotification(task: Task) {
        val notification = Notification(task = task, isSend = false)
        db.save(notification)
    }
}