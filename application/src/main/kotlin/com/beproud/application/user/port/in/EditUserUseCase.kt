package com.beproud.application.user.port.`in`

import com.beproud.domain.user.User

interface EditUserUseCase {
    fun editUser(name: String): User
}
