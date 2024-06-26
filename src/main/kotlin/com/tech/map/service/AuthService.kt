package com.tech.map.service

import com.tech.map.dto.ReqRes
import com.tech.map.model.User
import com.tech.map.repository.UserRepository
import com.tech.map.service.JwtUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service


@Service
class AuthService(
    @Autowired private val userRepository: UserRepository,
    @Autowired private val jwtUtils: JwtUtils,
    @Autowired private val passwordEncoder: PasswordEncoder,
    @Autowired private val authenticationManager: AuthenticationManager) {

    fun signUp(registrationRequest: ReqRes): ReqRes {
        val response = ReqRes()
        val newUser = User(
            username = registrationRequest.username,
            password = passwordEncoder.encode(registrationRequest.password),
            role = registrationRequest.role)

        val userResult = userRepository.save(newUser)

        if (userResult.getId()!! > 0) {
            response.user = userResult
            response.message = "User Saved Successfully"
            response.statusCode = 200
        } else {
            response.statusCode = 400
            response.message = "User Not Saved Successfully"
        }
        return response
    }
    fun signIn(signInRequest: ReqRes): ReqRes {
        val response = ReqRes()

        authenticationManager.authenticate(UsernamePasswordAuthenticationToken(signInRequest.username, signInRequest.password))
        val user = userRepository.findByUsername(signInRequest.username)
        println("USer is $user")
        val jwt = jwtUtils.generateToken(user)
        val refreshToken = jwtUtils.generateRefreshToken(HashMap(), user)
        response.statusCode = 200
        response.token = jwt
        response.refreshToken = refreshToken
        response.expirationDate = "24Hr"
        response.message = "Success"
        response.role = user.role
        response.username = user.username

        return response
    }

    fun refreshToken(refreshTokenRequest: ReqRes): ReqRes {
        var response = ReqRes()

        val username = jwtUtils.extractUsername(refreshTokenRequest.token)
        var user = userRepository.findByUsername(username = username)

        if (jwtUtils.isTokenValid(refreshTokenRequest.token, user)) {
            val jwt = jwtUtils.generateToken(user)
            response.statusCode = 200
            response.token = jwt
            response.expirationDate = "24Hr"
            response.message = "Successfully Refreshed Token"
        } else
            response.statusCode = 500

        return response

    }
    fun getAll(): MutableList<User> {
        return this.userRepository.findAll()
    }
    fun findUser(username: String): User {
        println(username)
        return userRepository.findByUsername(username)
    }

    fun changeUserPassword(registrationRequest: ReqRes): ReqRes {

        return signUp(registrationRequest)
    }

    fun deleteUser(user: User) {
        return userRepository.delete(user)
    }

}