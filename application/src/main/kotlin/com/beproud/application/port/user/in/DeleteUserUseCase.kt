package com.beproud.application.port.user.`in`

import java.util.UUID

interface DeleteUserUseCase {
    fun deleteUser(id: UUID)
}
