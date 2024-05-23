package com.beproud.bootstrap.user.adapter.`in`.web.dto

import com.beproud.application.user.port.`in`.command.CreateUserCommand

class UserRequest

data class CreateUserRequest(
    val name: String,
) {
    fun toCommand() =
        CreateUserCommand(
            name = name,
        )
}
