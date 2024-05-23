package com.beproud.bootstrap.user.adapter.`in`.web

import com.beproud.application.user.port.`in`.CreateUserUseCase
import com.beproud.bootstrap.user.adapter.`in`.web.dto.CreateUserRequest
import com.beproud.support.WebAdapter
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@WebAdapter
@RestController
@RequestMapping("/api/v1/users")
class UserController(
    private val createUserUseCase: CreateUserUseCase,
) {
    @PostMapping
    fun createUser(
        @Valid @RequestBody
        request: CreateUserRequest,
    ): ResponseEntity<Unit> {
        createUserUseCase.createUser(request.toCommand())
        return ResponseEntity.ok().build()
    }
}
