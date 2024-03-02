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

    @ManyToMany
    @JoinTable(
        name = "field_company",
        joinColumns = [JoinColumn(name = "company_id")],
        inverseJoinColumns = [JoinColumn(name = "field_id")]
    )
    val fields: MutableList<Field> = mutableListOf()


}
