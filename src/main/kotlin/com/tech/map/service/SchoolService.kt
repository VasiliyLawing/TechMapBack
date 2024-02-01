package com.tech.map.service

import com.tech.map.model.School
import com.tech.map.model.Student
import com.tech.map.repository.SchoolRepository
import org.springframework.stereotype.Service


@Service
class SchoolService (private val schoolRepository: SchoolRepository){

    fun getAll(): MutableIterable<School> {
        return schoolRepository.findAll()
    }
    fun getByID(id: Int): School {
        return schoolRepository.findById(id).orElse(null)
    }
    fun add(school: School) {
        schoolRepository.save(school)
    }
    fun remove(id: Int) {
        schoolRepository.deleteById(id)
    }
    fun update(school: School) {
        schoolRepository.save(school)
    }

}