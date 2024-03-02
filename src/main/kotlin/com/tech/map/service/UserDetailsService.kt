package com.tech.map.service

import com.tech.map.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsService(@Autowired private val userRepository: UserRepository): UserDetailsService {


    override fun loadUserByUsername(username: String): UserDetails {
        return userRepository.findByUsername(username)
    }

}