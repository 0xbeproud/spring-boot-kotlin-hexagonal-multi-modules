package com.beproud.application.port.user.`in`

import com.beproud.domain.user.User

interface GetUserUseCase {
    fun getUser(id: String): User
}