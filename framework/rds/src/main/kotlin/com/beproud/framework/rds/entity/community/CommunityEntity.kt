package com.beproud.framework.rds.entity.community

import com.beproud.framework.rds.support.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "community")
class CommunityEntity(
    @Column(name = "name", nullable = false)
    var name: String,
) : BaseEntity() {
    companion object {
        fun create(name: String): CommunityEntity =
            CommunityEntity(
                name = name,
            )
    }
}
