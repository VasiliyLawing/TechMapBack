package com.tech.map.repository

import com.tech.map.model.Company
import com.tech.map.model.Field
import org.springframework.data.jpa.repository.JpaRepository

interface FieldRepository: JpaRepository<Field, Int> {
}