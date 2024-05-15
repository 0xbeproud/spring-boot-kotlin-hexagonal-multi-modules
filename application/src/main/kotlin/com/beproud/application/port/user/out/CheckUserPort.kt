package com.beproud.application.port.user.out

import com.beproud.domain.user.User

interface CheckUserPort {
    fun checkNewUser(user: User)

    fun checkEditUser(user: User)

    fun checkDeleteUser(user: User)
}
