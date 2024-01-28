package com.tech.map.model

import jakarta.persistence.*


@Entity
@Table(name = "fields")
class Field {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null

    @ManyToMany(mappedBy = "fields", cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    private val companies: List<Company>? = null

    @OneToMany(mappedBy = "field", cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    private val students: List<Student>? = null
    val name: String? = null
}
