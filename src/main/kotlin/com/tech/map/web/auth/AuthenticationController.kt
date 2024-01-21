package com.tech.map.web.auth

import com.tech.map.service.AuthenticationService
import lombok.RequiredArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor

class AuthenticationController {
    private val service: AuthenticationService? = null
    @PostMapping("/register")
    fun register(
        @RequestBody request: RegisterRequest?
    ): ResponseEntity<AuthenticationResponse> {
        return ResponseEntity.ok(service!!.register(request!!))
    }

    @PostMapping("/authenticate")
    fun authenticate(
        @RequestBody request: AuthenticationRequest?
    ): ResponseEntity<AuthenticationResponse> {
        return ResponseEntity.ok(service.authenticate(request))
    }
}