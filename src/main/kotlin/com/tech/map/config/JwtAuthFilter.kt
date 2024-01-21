package com.tech.map.config

import com.tech.map.service.JwtUtils
import com.tech.map.service.UserDetailsService
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthFilter(@Autowired private val jwtUtils: JwtUtils, @Autowired private val userDetailsService: UserDetailsService): OncePerRequestFilter() {



    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val authHeader = request.getHeader("Authorization")
        var jwtToken: String? = null
        var username: String? = null

        if (authHeader.isNullOrBlank()) {
            filterChain.doFilter(request, response)
            return
        }

        jwtToken = authHeader.substring(7)
        username = jwtUtils.extractUsername(jwtToken)
        //TODO: Simplify
        if (username != null && SecurityContextHolder.getContext().authentication == null) {
            val userDetails = userDetailsService.loadUserByUsername(username)

            if (jwtUtils.isTokenValid(jwtToken, userDetails)) {
                var securityContext = SecurityContextHolder.createEmptyContext()
                val token = UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.authorities
                )
                token.details = WebAuthenticationDetailsSource().buildDetails(request)
                securityContext.authentication = token
                SecurityContextHolder.setContext(securityContext)
            }
        }

        filterChain.doFilter(request, response)
    }

}