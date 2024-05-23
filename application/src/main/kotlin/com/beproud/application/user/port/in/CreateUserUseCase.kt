package com.beproud.application.user.port.`in`

import com.beproud.application.user.port.`in`.command.CreateUserCommand
import com.beproud.domain.user.User

interface CreateUserUseCase {
    fun createUser(command: CreateUserCommand): User
}
