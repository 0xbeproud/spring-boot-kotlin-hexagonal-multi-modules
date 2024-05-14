package com.beproud.application.port.user.`in`

import com.beproud.domain.user.User

interface EditUserUseCase {
    fun edit(name: String): User
}