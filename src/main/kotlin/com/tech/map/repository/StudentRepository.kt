package com.tech.map.repository

import com.tech.map.model.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository: JpaRepository<Student, Int> {

}