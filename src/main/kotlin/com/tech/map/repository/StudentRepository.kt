package com.tech.map.repository

import com.tech.map.model.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository: JpaRepository<Student, Int> {
    fun findByLatitudeGreaterThanOrderByName (n: Double): List<Student>
}

fun StudentRepository.nearByStudents(n: Double) = findByLatitudeGreaterThanOrderByName(n)