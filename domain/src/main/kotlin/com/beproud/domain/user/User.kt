package com.beproud.domain.user

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import com.beproud.domain.BaseEntity

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
