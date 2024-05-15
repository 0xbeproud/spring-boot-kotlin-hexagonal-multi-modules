package com.beproud.application.port.user.`in`

import com.beproud.application.port.user.`in`.command.CreateUserCommand
import com.beproud.domain.user.User

interface CreateUserUseCase {
    fun createUser(command: CreateUserCommand): User
}
