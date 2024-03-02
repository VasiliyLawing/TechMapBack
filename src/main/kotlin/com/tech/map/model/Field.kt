package com.tech.map.model

import jakarta.persistence.*


@Entity
@Table(name = "fields")
class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null

    @ManyToMany(mappedBy = "fields", cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    private val companies: MutableList<Company> = mutableListOf()

    @OneToMany(mappedBy = "field", cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    private val students: MutableList<Student> = mutableListOf()
    val name: String? = null

}
