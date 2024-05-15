package com.beproud.application.port.user.service

import com.beproud.application.port.user.`in`.EditUserUseCase
import com.beproud.application.port.user.out.CheckUserPort
import com.beproud.application.port.user.out.RetrieveUserPort
import com.beproud.application.port.user.out.SaveUserPort
import com.beproud.application.support.UseService
import com.beproud.domain.user.User

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
