package com.beproud.application.user.service

import com.beproud.application.user.port.`in`.DeleteUserUseCase
import com.beproud.application.user.port.out.CheckUserPort
import com.beproud.application.user.port.out.DeleteUserPort
import com.beproud.application.user.port.out.RetrieveUserPort
import com.beproud.support.UseService
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
