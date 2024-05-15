package com.beproud.application.port.user.service

import com.beproud.application.port.user.`in`.CreateUserUseCase
import com.beproud.application.port.user.`in`.command.CreateUserCommand
import com.beproud.application.port.user.out.CheckUserPort
import com.beproud.application.port.user.out.SaveUserPort
import com.beproud.application.support.UseService
import com.beproud.domain.user.User
import java.util.UUID

@UseService
class CreateUserService(
    private val checkUserPort: CheckUserPort,
    private val saveUserPort: SaveUserPort,
) : CreateUserUseCase {
    override fun createUser(command: CreateUserCommand): User {
        val user = User(id = UUID.randomUUID(), name = command.name)
        checkUserPort.checkNewUser(user)
        saveUserPort.saveUser(user)
        return user
    }
}
