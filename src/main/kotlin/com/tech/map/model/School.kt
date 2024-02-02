package com.tech.map.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name="schools")
class School {

    @Id
    var id: Int? = null

    var name: String? = null
    var longitude: Double? = null
    var latitude: Double? = null
}