package com.tech.map.repository


import com.tech.map.model.Company
import org.springframework.data.jpa.repository.JpaRepository

interface CompanyRepository: JpaRepository<Company, Int> {
}