package com.kaio.klist.entity

import jakarta.persistence.*

@Entity(name="user")
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id", nullable = false)
    val id: Long? = null,
    @Column(name = "name", nullable = false)
    var name: String? = null,
    @Column(name = "email", nullable = false)
    var email: String? = null,
    @Column(name = "password", nullable = false)
    var password: String? = null,
    @OneToMany(mappedBy = "user")
    var tasks: Set<Task>? = null

)