package com.tech.map.service

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.security.Key
import java.util.*
import java.util.function.Function
import kotlin.collections.HashMap


@Service
class JwtService {
    companion object var SECRET_KEY = "23AF7B2C4E89D1F0A67C5B3E9D8F4A2D4E6C7A8F0B2D3E5F8A9B0C1D2E3F4A5"

    fun extractUsername(token: String): String {
        return extractClaim(token, Claims::getSubject)
    }

    fun generateToken(extraClaims: Map<String, Any>, userDetails: UserDetails): String? {
        return Jwts
            .builder()
            .setClaims(extraClaims)
            .setSubject(userDetails.username)
            .setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis() + 1000 * 60 * 24)) // 1000 mil == 1 sec
            .signWith(getSignInKey(), SignatureAlgorithm.HS256)
            .compact()
    }

    fun generateToken(userDetails: UserDetails) {
        generateToken(HashMap(), userDetails) // Be careful using this
    }

    fun isTokenValid(token: String, userDetails: UserDetails): Boolean {
        val username = extractUsername(token)

        return username == userDetails.username && !isTokenExpired(token)
    }

    fun isTokenExpired(token: String): Boolean {
        return extractExpiration(token).before(Date())
    }

    fun extractExpiration(token: String): Date {
        return extractClaim(token, Claims::getExpiration)
    }

    fun<T> extractClaim(token: String, claimResolver: Function<Claims, T>): T {
        val claims: Claims = extractAllClaims(token)
        return claimResolver.apply(claims)
    }


    fun getSignInKey(): Key {
        val keyBytes = Decoders.BASE64.decode(SECRET_KEY)
        return Keys.hmacShaKeyFor(keyBytes)
    }
    private fun extractAllClaims(token: String): Claims {
        return Jwts
            .parserBuilder()
            .setSigningKey(getSignInKey())
            .build()
            .parseClaimsJws(token)
            .body
    }
}
