package com.tech.map.repository

import com.tech.map.model.School
import org.springframework.data.jpa.repository.JpaRepository

interface SchoolRepository: JpaRepository<School, Int> {}