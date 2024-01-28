package com.tech.map.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table

@Entity
@Table(name = "companies")
class Company {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    val name: String? = null
    val latitude: Double? = null
    val longitude : Double? = null

    @ManyToMany(mappedBy = "companies")
    val fields: List<Field>? = null
}
