package com.beproud.bootstrap.adapter.`in`.web.user.dto

import com.beproud.application.port.user.`in`.command.CreateUserCommand

class UserRequest

data class CreateUserRequest(
    val name: String,
) {
    fun toCommand() =
        CreateUserCommand(
            name = name,
        )
}