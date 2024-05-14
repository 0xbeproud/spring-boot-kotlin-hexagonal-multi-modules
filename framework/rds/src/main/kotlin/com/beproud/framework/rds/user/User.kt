package com.beproud.framework.rds.user

import com.beproud.framework.rds.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "user")
class User(

    @Column(name = "name", nullable = false)
    var name: String,
) : BaseEntity() {

    companion object {
        fun create(
            name: String,
        ): User = User(
            name = name,
        )
    }
}
