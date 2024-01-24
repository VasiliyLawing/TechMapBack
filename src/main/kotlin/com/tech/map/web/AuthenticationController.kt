package com.tech.map.web

import com.tech.map.service.AuthService
import com.tech.map.dto.ReqRes
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin()

@RestController
@RequestMapping("/api/auth")
class AuthenticationController(@Autowired private val authService: AuthService) {

    @PostMapping("/register/")
    fun signUp(@RequestBody signUpRequest: ReqRes): ResponseEntity<ReqRes> = ResponseEntity.ok(authService.signUp(signUpRequest))

    @PostMapping("/login/")
    fun signIn(@RequestBody signInRequest: ReqRes): ResponseEntity<ReqRes> = ResponseEntity.ok(authService.signIn(signInRequest))

    @PostMapping("/refresh/")
    fun refreshToken(@RequestBody refreshTokenRequest: ReqRes): ResponseEntity<ReqRes> = ResponseEntity.ok(authService.refreshToken(refreshTokenRequest))

}