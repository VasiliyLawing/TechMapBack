package com.tech.map.repository

import com.tech.map.model.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface UserRepository : JpaRepository<User?, Int?> {
    fun findByName(email: String?): Optional<User?>?
}