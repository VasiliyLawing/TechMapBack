package com.tech.map.model

import jakarta.persistence.*


@Entity
@Table(name="schools")
class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    val id: Int? = null

    val name: String? = null
    val longitude: Double? = null
    val latitude: Double? = null
}