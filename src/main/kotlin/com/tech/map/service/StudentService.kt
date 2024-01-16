package com.tech.map.service

import com.tech.map.repository.StudentRepository
import com.tech.map.model.Student
import org.springframework.stereotype.Service

@Service
class StudentService(private val studentRepository: StudentRepository) {


    fun getAll(): MutableIterable<Student> {
        return studentRepository.findAll()
    }
    fun getByID(id: Int): Student {
        return studentRepository.findById(id).orElse(null)
    }
    fun add(student: Student) {
        studentRepository.save(student)
    }
    fun remove(id: Int) {
        studentRepository.deleteById(id)
    }

}