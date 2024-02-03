package com.tech.map.web

import com.tech.map.model.Student
import com.tech.map.service.StudentService
import org.springframework.web.bind.annotation.*


@RestController
class StudentsController (private var studentService: StudentService){



    @GetMapping("/api/students/")
    fun getAll(): MutableIterable<Student> {
        return studentService.getAll()
    }
    @GetMapping("/api/students/{id}/")
    fun get(@PathVariable id: Int): Student {
        return studentService.getByID(id)
    }

    @DeleteMapping("/api/students/{id}/")
    fun remove(@PathVariable id: Int) {
        studentService.remove(id)
    }
    @PostMapping("/api/students/add/")
    fun add(@RequestBody student: Student) {
        studentService.add(student)
    }

    @PutMapping("/api/students/update/")
    fun update(@RequestBody student: Student) {
        studentService.update(student)
    }
}