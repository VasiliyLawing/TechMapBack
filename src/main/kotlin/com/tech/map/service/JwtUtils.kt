package com.tech.map.service

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import java.util.Base64
import java.util.Date
import java.util.function.Function
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

@Component
class JwtUtils {
    private var key: SecretKey? = null
    companion object {
        private val EXPIRATION_TIME = 86400000 // 24 hours
    }

    init {
        val secretString = "93913810874588hfr9724r3h197db39j1n9f311d39udj1n39ud31je193ne319en139eu13nd9ffun412crybfhnklmqekdqw"
        val keyBytes: ByteArray = Base64.getDecoder().decode(secretString.toByteArray(StandardCharsets.UTF_8))
        key = SecretKeySpec(keyBytes, "HmacSHA256")
    }

    fun generateToken(userDetails: UserDetails): String {
        return Jwts.builder()
            .setSubject(userDetails.username)
            .setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(key)
            .compact()
    }

    fun generateRefreshToken(claims: HashMap<String, Any>, userDetails: UserDetails): String {
        return Jwts.builder()
            .setClaims(claims)
            .setSubject(userDetails.username)
            .setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(key)
            .compact()
    }

    fun isTokenValid(token: String, userDetails: UserDetails): Boolean {
        val username = extractUsername(token)
        return (username == userDetails.username && !isTokenExpired(token))
    }
    fun isTokenExpired(token: String): Boolean {
        return extractClaims(token, Claims::getExpiration).before(Date())
    }

    fun extractUsername(token: String): String {
        return extractClaims(token, Claims::getSubject)
    }
    fun <T>extractClaims(token: String, claimsTFunction: Function<Claims, T>): T {
        return claimsTFunction.apply(Jwts
            .parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .body)
    }


}