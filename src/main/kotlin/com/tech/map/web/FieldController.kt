package com.tech.map.web

import com.tech.map.model.Company
import com.tech.map.model.Field
import com.tech.map.service.CompanyService
import com.tech.map.service.FieldService
import org.springframework.web.bind.annotation.*

@RestController
class FieldController(var fieldService: FieldService) {

    @GetMapping("/api/fields/")
    fun getAll(): Iterable<Field> {
        return fieldService.getAll()
    }
    @GetMapping("/api/fields/{id}/")
    fun get(@PathVariable id: Int): Field {
        return fieldService.getByID(id)
    }

    @DeleteMapping("/api/fields/{id}/")
    fun delete(@PathVariable id: Int) {
        fieldService.remove(id)
    }
    @PostMapping("/api/fields/add/")
    fun add(@RequestBody field: Field) {
        fieldService.add(field)
    }
    @PutMapping("/api/fields/update/")
    fun update(@RequestBody field: Field) {
        fieldService.update(field)
    }
}