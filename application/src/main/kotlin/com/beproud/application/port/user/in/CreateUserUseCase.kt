package com.beproud.application.port.user.`in`

import com.beproud.domain.user.User


interface CreateUserUseCase {
    fun createUser(name: String): User
}