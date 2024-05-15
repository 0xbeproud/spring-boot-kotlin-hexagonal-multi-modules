package com.beproud.application.port.user.out

import com.beproud.domain.user.User
import java.util.UUID

interface RetrieveUserPort {
    fun retrieveUserById(id: UUID): User

    fun retrieveUserByName(name: String): User
}
