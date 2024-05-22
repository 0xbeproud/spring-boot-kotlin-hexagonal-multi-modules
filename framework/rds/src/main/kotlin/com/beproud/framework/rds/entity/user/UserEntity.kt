package com.beproud.framework.rds.entity.user

import com.beproud.framework.rds.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "user")
class UserEntity(
    @Column(name = "name", nullable = false)
    var name: String,
) : BaseEntity() {
    companion object {
        fun create(name: String): UserEntity =
            UserEntity(
                name = name,
            )
    }
}
