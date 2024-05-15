package com.beproud.domain.user

import java.util.UUID

data class User(
    val id: UUID,
    val name: String,
) {
    init {
        require(name.isNotBlank()) { "name must not be blank" }
    }
}
