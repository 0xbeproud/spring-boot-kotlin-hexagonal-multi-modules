package com.beproud.application.port.user.service

import com.beproud.application.port.user.`in`.DeleteUserUseCase
import com.beproud.application.port.user.out.CheckUserPort
import com.beproud.application.port.user.out.DeleteUserPort
import com.beproud.application.port.user.out.RetrieveUserPort
import com.beproud.application.support.UseService
import java.util.UUID

@UseService
class DeleteUserService(
    private val retrieveUserPort: RetrieveUserPort,
    private val checkUserPort: CheckUserPort,
    private val deleteUserPort: DeleteUserPort,
) : DeleteUserUseCase {
    override fun deleteUser(id: UUID) {
        val user = retrieveUserPort.retrieveUserById(id)
        checkUserPort.checkDeleteUser(user)
        deleteUserPort.deleteUser(user)
    }
}
