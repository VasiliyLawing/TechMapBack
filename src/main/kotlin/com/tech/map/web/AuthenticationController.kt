package com.tech.map.web

import com.tech.map.config.AuthService
import com.tech.map.dto.ReqRes
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/auth")
class AuthenticationController(@Autowired private val authService: AuthService) {

    @PostMapping("/signup")
    fun signUp(@RequestBody signUpRequest: ReqRes): ResponseEntity<ReqRes> {
        return ResponseEntity.ok(authService.signUp(signUpRequest))
    }
    @PostMapping("/signIn")
    fun signIn(@RequestBody signInRequest: ReqRes): ResponseEntity<ReqRes> {
        println("WORKES")
        return ResponseEntity.ok(authService.signIn(signInRequest))
    }
    @PostMapping("/refresh")
    fun refreshToken(@RequestBody refreshTokenRequest: ReqRes): ResponseEntity<ReqRes> {
        return ResponseEntity.ok(authService.refreshToken(refreshTokenRequest))
    }
}