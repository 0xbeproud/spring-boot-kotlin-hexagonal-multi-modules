package com.beproud.application.user

import com.beproud.domain.user.User

interface EditUserUsecase {
    fun edit(id: String, name: String): User
}