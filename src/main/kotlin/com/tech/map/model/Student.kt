package com.tech.map.model

import jakarta.persistence.*


@Entity
@Table(name = "students")
class Student {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    val name: String? = null
    val latitude: Double? = null
    val longitude : Double? = null
    @ManyToOne
    @JoinColumn(name = "field_id") // FETCH TYPE LAZY FOR BETTER STORAGE
    val field: Field? = null
}
