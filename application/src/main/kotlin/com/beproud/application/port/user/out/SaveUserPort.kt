package com.beproud.application.port.user.out

import com.beproud.domain.user.User

interface SaveUserPort {
    fun saveUser(user: User)
    fun editUser(user: User)
}