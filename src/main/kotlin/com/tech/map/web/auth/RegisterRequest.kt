package com.tech.map.web.auth

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class RegisterRequest {
    private val username: String? = null
    private val password: String? = null

}