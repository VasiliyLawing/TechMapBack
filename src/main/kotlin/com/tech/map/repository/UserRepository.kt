package com.tech.map.repository

import com.tech.map.model.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserRepository: JpaRepository<User, Int> {
    fun findByUsername(username: String): User
}
