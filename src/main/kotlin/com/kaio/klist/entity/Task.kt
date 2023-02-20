package com.kaio.klist.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "task")
class Task(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id", nullable = false)
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "user_id", nullable = false)
    var user: User? = null,

    @Column(name = "title", nullable = false)
    var title: String? = null,

    @Column(name = "description", nullable = false)
    var description: String? = null,

    @Column(name = "done", nullable = false)
    var done: Boolean? = null,

    @Column(name = "notification", nullable = false)
    var notification: Boolean? = null,

    @Column(name = "is_notificated", nullable = false)
    var isNotificated: Boolean? = null,

    @Column(name = "date", nullable = false)
    var date: LocalDateTime? = null,

    @JsonIgnore
    @OneToOne(mappedBy = "task")
    var notificationTask: Notification? = null,
)