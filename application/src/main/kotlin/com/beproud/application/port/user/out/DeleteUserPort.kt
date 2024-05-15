package com.beproud.application.port.user.out

import com.beproud.domain.user.User

interface DeleteUserPort {
    fun deleteUser(user: User)
}
