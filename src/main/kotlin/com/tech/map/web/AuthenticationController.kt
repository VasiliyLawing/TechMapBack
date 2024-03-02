package com.tech.map.web

import com.tech.map.service.AuthService
import com.tech.map.dto.ReqRes
import com.tech.map.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
class AuthenticationController(@Autowired private val authService: AuthService) {

    @PostMapping("api/admin/auth/register/")
    fun signUp(@RequestBody signUpRequest: ReqRes): ResponseEntity<ReqRes> = ResponseEntity.ok(authService.signUp(signUpRequest))

    @PostMapping("api/public/auth/login/")
    fun signIn(@RequestBody signInRequest: ReqRes): ResponseEntity<ReqRes> = ResponseEntity.ok(authService.signIn(signInRequest))

    @PostMapping("api/public/auth/refresh/")
    fun refreshToken(@RequestBody refreshTokenRequest: ReqRes): ResponseEntity<ReqRes> = ResponseEntity.ok(authService.refreshToken(refreshTokenRequest))

    @PostMapping("api/admin/auth/delete/")
    fun deleteUser(@RequestBody username: String) {

        val user = authService.findUser(username)

        ResponseEntity.ok(authService.deleteUser(user))
    }

    @PostMapping("api/admin/auth/changePassword/")
    fun changePassword(@RequestBody user: ReqRes): ReqRes {
        return authService.changeUserPassword(user)
    }

    @GetMapping("api/admin/auth/getAll/")
    fun getAll(): MutableList<User> {
        return authService.getAll()
    }
}