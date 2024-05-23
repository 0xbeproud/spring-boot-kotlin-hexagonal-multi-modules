package com.beproud.framework.rds.user.entity

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserRepository : JpaRepository<UserEntity, UUID> {
    fun findByName(name: String): UserEntity?
}
