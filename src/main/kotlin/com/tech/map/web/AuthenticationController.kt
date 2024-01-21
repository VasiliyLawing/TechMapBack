package com.tech.map.web

import com.tech.map.config.AuthService
import com.tech.map.dto.UserLoginRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhot:4200"], allowCredentials = "true")

@RestController
@RequestMapping("/auth")
class AuthenticationController(@Autowired private val authService: AuthService) {

    @PostMapping("/register/")
    fun signUp(@RequestBody signUpRequest: UserLoginRequest): ResponseEntity<UserLoginRequest> = ResponseEntity.ok(authService.signUp(signUpRequest))

    @PostMapping("/login/")
    fun signIn(@RequestBody signInRequest: UserLoginRequest): ResponseEntity<UserLoginRequest> = ResponseEntity.ok(authService.signIn(signInRequest))

    @PostMapping("/refresh/")
    fun refreshToken(@RequestBody refreshTokenRequest: UserLoginRequest): ResponseEntity<UserLoginRequest> = ResponseEntity.ok(authService.refreshToken(refreshTokenRequest))

}