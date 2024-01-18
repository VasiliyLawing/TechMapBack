package com.tech.map.model

import jakarta.persistence.*

@Entity
@Table(name = "fields")
class Field {
    @Id
    val id: Long? = null
    val name: String? = null
}