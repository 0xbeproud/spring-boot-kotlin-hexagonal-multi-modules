package com.beproud.application.user.port.out

import com.beproud.domain.user.User

interface DeleteUserPort {
    fun deleteUser(user: User)
}
