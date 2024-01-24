package com.tech.map.web

import com.tech.map.model.Company
import com.tech.map.service.CompanyService
import org.springframework.web.bind.annotation.*

//@CrossOrigin()
@RestController
class CompaniesController(var companyService: CompanyService) {



    @GetMapping("/api/companies/")
    fun getAll(): Iterable<Company> {
        return companyService.getAll()
    }
    @GetMapping("/api/companies/{id}/")
    fun get(@PathVariable id: Int): Company {
        return companyService.getByID(id)
    }

    @DeleteMapping("/api/companies/{id}/")
    fun delete(@PathVariable id: Int) {
        companyService.remove(id)
    }
    @PostMapping("/api/companies/add/")
    fun add(@RequestBody company: Company) {
        companyService.add(company)
    }
}