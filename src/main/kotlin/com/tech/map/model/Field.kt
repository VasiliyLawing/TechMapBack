package com.tech.map.model

import jakarta.persistence.*


@Entity
@Table(name = "fields")
class Field {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null

    @ManyToMany
    @JoinTable(
        name = "field_company",
        joinColumns = [JoinColumn(name = "field_id")],
        inverseJoinColumns = [JoinColumn(name = "company_id")]
    )
    private val companies: List<Company>? = null

    @OneToMany(mappedBy = "field")
    private val students: List<Student>? = null
    val name: String? = null
}
