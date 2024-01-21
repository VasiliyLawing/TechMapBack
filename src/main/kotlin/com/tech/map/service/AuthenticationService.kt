package com.tech.map.service

import com.tech.map.model.Role
import com.tech.map.repository.UserRepository
import com.tech.map.web.auth.AuthenticationRequest
import com.tech.map.web.auth.AuthenticationResponse
import com.tech.map.web.auth.RegisterRequest
import lombok.RequiredArgsConstructor
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class AuthenticationService(private val repository: UserRepository, private val passwordEncoder: PasswordEncoder) {



    fun register(request: RegisterRequest): AuthenticationResponse {
        val user = User.builder()
            .username(request.username)
            .password(passwordEncoder.encode(request.password))
            .roles(Role.USER.toString())
            .build()
        repository.save(user)

        TODO()
    }

    fun request(request: AuthenticationRequest): AuthenticationRequest {
        TODO()
    }

}