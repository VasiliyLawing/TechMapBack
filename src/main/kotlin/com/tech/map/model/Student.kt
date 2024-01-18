package com.tech.map.model

import jakarta.persistence.*


@Entity
@Table(name = "students")
class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    val name: String? = null
    val latitude: Double? = null
    val longitude : Double? = null

    @ManyToMany
    val field: List<Field>? = null
}
