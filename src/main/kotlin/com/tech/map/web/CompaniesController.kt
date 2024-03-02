package com.tech.map.web

import com.tech.map.model.Company
import com.tech.map.model.Student
import com.tech.map.service.CompanyService
import org.springframework.web.bind.annotation.*

@RestController
class CompaniesController(var companyService: CompanyService) {

    @GetMapping("/api/public/companies/")
    fun getAll(): Iterable<Company> {
        return companyService.getAll()
    }
    @GetMapping("/api/public/companies/{id}/")
    fun get(@PathVariable id: Int): Company {
        return companyService.getByID(id)
    }

    @DeleteMapping("/api/user/companies/{id}/")
    fun delete(@PathVariable id: Int) {
        companyService.remove(id)
    }
    @PostMapping("/api/user/companies/add/")
    fun add(@RequestBody company: Company) {
        companyService.add(company)
    }
    @PutMapping("/api/user/companies/update/")
    fun update(@RequestBody company: Company) {
        companyService.update(company)
    }
}