package com.kaio.klist.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
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

    @Lob
    @Column(name = "photo", nullable = true)
    var photo: ByteArray? = null,

    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    var tasks: Set<Task>? = emptySet()
)