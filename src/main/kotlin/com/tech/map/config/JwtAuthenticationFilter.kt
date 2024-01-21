package com.tech.map.config

import com.tech.map.service.JwtService
import jakarta.annotation.Nonnull
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import lombok.RequiredArgsConstructor
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.web.authentication.WebAuthenticationDetails
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter


@Component
@RequiredArgsConstructor
class JwtAuthenticationFilter: OncePerRequestFilter() {

    val jwtService: JwtService? = null
    private val userDetailsService: UserDetailsService? = null
    override fun doFilterInternal(
        @Nonnull request: HttpServletRequest,
        @Nonnull response: HttpServletResponse,
        @Nonnull filterChain: FilterChain
    ) {
        val authHeader = request.getHeader("Authorization")
        val jwt: String?

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response)
            return
        }

        jwt = authHeader.substring(7) // Bearer
        val username: String? = jwtService?.extractUsername(jwt)

        val authenticated = SecurityContextHolder.getContext().authentication

        if (username != null && authenticated == null) {
            val userDetails = this.userDetailsService?.loadUserByUsername(username)

            if (userDetails?.let { jwtService?.isTokenValid(jwt, it) } == true) {
                val authToken = UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.authorities
                )
                authToken.details = WebAuthenticationDetailsSource().buildDetails(request)
                SecurityContextHolder.getContext().authentication = authToken
            }
        }

        filterChain.doFilter(request, response)
    }

}