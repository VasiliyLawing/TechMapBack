package com.tech.map.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Table


@Entity
@Table(name = "students")
class Student {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    val name: String? = null
    val latitude: Double? = null
    val longitude : Double? = null
    val field: String? = null
}
