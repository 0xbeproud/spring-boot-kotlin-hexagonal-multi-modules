package com.beproud.application.user.service

import com.beproud.application.user.port.`in`.CreateUserUseCase
import com.beproud.application.user.port.`in`.command.CreateUserCommand
import com.beproud.application.user.port.out.CheckUserPort
import com.beproud.application.user.port.out.SaveUserPort
import com.beproud.domain.user.User
import com.beproud.support.UseService
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
