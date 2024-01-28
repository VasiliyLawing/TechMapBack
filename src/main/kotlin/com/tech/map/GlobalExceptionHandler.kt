package com.tech.map

import jakarta.persistence.EntityNotFoundException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException::class)
    fun handleEntityNotFoundException(ex: EntityNotFoundException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse("Entity not found", ex.message ?: "")
        return ResponseEntity(errorResponse, HttpStatus.NOT_FOUND)
    }

    data class ErrorResponse(val message: String, val details: String)
}
