package com.tech.map.service

import com.tech.map.model.Company
import com.tech.map.repository.CompanyRepository
import org.springframework.stereotype.Service

@Service
class CompanyService(private val companyRepository: CompanyRepository) {


    fun getAll(): MutableIterable<Company> {
        return companyRepository.findAll()
    }
    fun getByID(id: Int): Company {
        return companyRepository.findById(id).orElse(null)
    }
    fun add(company: Company) {
        companyRepository.save(company)
    }
    fun remove(id: Int) {
        companyRepository.deleteById(id)
    }

}