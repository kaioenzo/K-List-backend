package com.kaio.klist.entity

import jakarta.persistence.*

@Entity
class Notification(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id", nullable = false)
    val id: Long? = null,

    @Column
    var isSend: Boolean = false,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    val task: Task? = null,
)