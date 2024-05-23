package com.beproud.application.user.port.`in`

import java.util.UUID

interface DeleteUserUseCase {
    fun deleteUser(id: UUID)
}
