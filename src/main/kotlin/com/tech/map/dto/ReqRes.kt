package com.tech.map.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.tech.map.model.User
import lombok.Data


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
class ReqRes {
    var statusCode: Int? = null
    var message: String? = null
    var token: String = ""
    var refreshToken: String? = null
    var expirationDate: String? = null
    var username: String = ""
    var password: String = ""
    var role: String = ""
    var user: User? = null
}