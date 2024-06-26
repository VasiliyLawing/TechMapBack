package com.tech.map.web

import com.tech.map.model.School
import com.tech.map.model.Student
import com.tech.map.service.SchoolService
import com.tech.map.service.StudentService
import org.springframework.web.bind.annotation.*

//@CrossOrigin()

@RestController
class SchoolController (private var schoolService: SchoolService){

    @GetMapping("/api/public/schools/")
    fun getAll(): MutableIterable<School> {
        return schoolService.getAll()
    }
    @GetMapping("/api/public/schools/{id}/")
    fun get(@PathVariable id: Int): School {
        return schoolService.getByID(id)
    }

    @DeleteMapping("/api/user/schools/{id}/")
    fun remove(@PathVariable id: Int) {
        schoolService.remove(id)
    }
    @PostMapping("/api/user/schools/add/")
    fun add(@RequestBody school: School) {
        schoolService.add(school)
    }

    @PutMapping("/api/user/schools/update/")
    fun update(@RequestBody school: School) {
        schoolService.update(school)
    }
}