package com.tech.map.model

import jakarta.persistence.*

@Entity
@Table(name = "companies")
class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    val name: String? = null
    val latitude: Double? = null
    val longitude : Double? = null

    @ManyToMany9034321111
    val field: List<Field>? = null
}
