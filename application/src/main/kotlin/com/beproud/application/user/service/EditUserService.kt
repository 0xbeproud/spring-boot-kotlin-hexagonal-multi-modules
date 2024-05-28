package com.beproud.application.user.service

import com.beproud.application.user.port.`in`.EditUserUseCase
import com.beproud.application.user.port.out.CheckUserPort
import com.beproud.application.user.port.out.RetrieveUserPort
import com.beproud.application.user.port.out.SaveUserPort
import com.beproud.domain.user.User
import com.beproud.support.UseService

@UseService
class EditUserService(
    private val checkUserPort: CheckUserPort,
    private val retrieveUserPort: RetrieveUserPort,
    private val saveUserPort: SaveUserPort,
) : EditUserUseCase {
    override fun editUser(name: String): User {
        val user = retrieveUserPort.retrieveUserByName(name)
        checkUserPort.checkEditUser(user)
        saveUserPort.editUser(user)
        return user
    }
}
