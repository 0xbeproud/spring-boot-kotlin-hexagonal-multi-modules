package com.beproud.domain.user

import java.util.UUID

data class User(
    val id: UUID,
    val name: String,
) {
   fun createUser(name: String): User {
       return User(
           id = UUID.randomUUID(),
           name = name,
       )
   }
}