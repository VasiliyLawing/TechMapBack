package com.tech.map.model

import jakarta.persistence.*


@Entity
@Table(name="schools")
class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    var name: String? = null
    var longitude: Double? = null
    var latitude: Double? = null
}