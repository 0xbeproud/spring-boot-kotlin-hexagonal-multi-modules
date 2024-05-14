package com.beproud.domain.community

import com.beproud.domain.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "community")
class Community(
    @Column(name = "name", nullable = false)
    var name: String,
) : BaseEntity() {

    companion object {
        fun create(
            name: String,
        ): Community = Community(
            name = name
        )
    }
}
