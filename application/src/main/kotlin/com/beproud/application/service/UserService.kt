package com.beproud.application.service

import com.beproud.application.port.user.`in`.CreateUserUseCase
import com.beproud.application.port.user.`in`.EditUserUseCase
import com.beproud.application.port.user.`in`.GetUserUseCase
import com.beproud.application.port.user.`in`.UpdateUserUseCase
import com.beproud.application.port.user.out.RetrieveUserPort
import com.beproud.application.port.user.out.SaveUserPort
import com.beproud.application.support.UseCase
import com.beproud.domain.user.User
import java.util.UUID

@UseCase
class UserService(
    private val retrieveUserPort: RetrieveUserPort,
    private val saveUserPort: SaveUserPort,
) : CreateUserUseCase, EditUserUseCase, GetUserUseCase, UpdateUserUseCase {
    override fun createUser(name: String): User {
        val user = User(id = UUID.randomUUID(), name = name)
        saveUserPort.saveUser(user)
        return user
    }

    override fun getUser(id: String): User {
        TODO("Not yet implemented")
    }
}