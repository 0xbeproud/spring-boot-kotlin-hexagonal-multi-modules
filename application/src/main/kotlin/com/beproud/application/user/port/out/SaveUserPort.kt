package com.beproud.application.user.port.out

import com.beproud.domain.user.User

interface SaveUserPort {
    fun saveUser(user: User)

    fun editUser(user: User)
}
