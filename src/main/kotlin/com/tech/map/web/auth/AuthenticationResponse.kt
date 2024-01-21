package com.tech.map.web.auth

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class AuthenticationResponse {
    private var token: String? = null


}