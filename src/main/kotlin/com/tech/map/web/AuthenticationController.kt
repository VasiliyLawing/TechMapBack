package com.tech.map.web

import com.tech.map.service.AuthService
import com.tech.map.dto.ReqRes
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
class AuthenticationController(@Autowired private val authService: AuthService) {

    @PostMapping("api/register/")
    fun signUp(@RequestBody signUpRequest: ReqRes): ResponseEntity<ReqRes> = ResponseEntity.ok(authService.signUp(signUpRequest))

    @PostMapping("api/auth/login/")
    fun signIn(@RequestBody signInRequest: ReqRes): ResponseEntity<ReqRes> = ResponseEntity.ok(authService.signIn(signInRequest))

    @PostMapping("api/auth/refresh/")
    fun refreshToken(@RequestBody refreshTokenRequest: ReqRes): ResponseEntity<ReqRes> = ResponseEntity.ok(authService.refreshToken(refreshTokenRequest))

    @DeleteMapping("api/auth/delete/")
    fun deleteUser(@RequestBody user: ReqRes) {
        ResponseEntity.ok(authService.deleteUser(user))
    }
    @GetMapping("api/auth/getAll/")
    fun deleteUser(@RequestBody user: ReqRes): MutableList<User> {
        return authService.getAll()
    }
}