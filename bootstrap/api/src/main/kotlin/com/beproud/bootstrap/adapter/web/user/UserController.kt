package com.beproud.bootstrap.adapter.web.user

import com.beproud.application.port.user.`in`.CreateUserUseCase
import com.beproud.bootstrap.adapter.web.user.dto.CreateUserRequest
import com.beproud.bootstrap.support.WebAdapter
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@WebAdapter
@RestController
@RequestMapping("/api/v1/users")
class UserController (
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
