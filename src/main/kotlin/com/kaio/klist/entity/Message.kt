package com.kaio.klist.entity

import jakarta.persistence.*

@Entity
class Message(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id", nullable = false)
    var id: Long? = null,
    @Column(name = "message", nullable = false)
    var message: String? = null,
)
