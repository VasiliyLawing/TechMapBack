package com.tech.map.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import lombok.Data


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
class ReqRes {
    private var statusCode: Int? = null
    private var message: String? = null
    private var token: String? = null
    private var refreshToken: String? = null
    private var expirationDate: String? = null
    private var name: String? = null
    private var password: String? = null
    private var role: String? = null
    private var allUsers: String? = null
}