package com.beproud.application.user

import com.beproud.domain.user.User

interface CreateUserUsecase {
    // dto로 대체
    fun create(name: String): User
}