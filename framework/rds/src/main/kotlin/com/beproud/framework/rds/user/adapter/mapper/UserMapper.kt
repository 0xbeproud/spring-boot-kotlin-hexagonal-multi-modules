package com.beproud.framework.rds.user.adapter.mapper

import com.beproud.domain.user.User
import com.beproud.framework.rds.user.entity.UserEntity
import com.beproud.framework.support.Mapper

@Mapper
class UserMapper {
    fun toDomain(userEntity: UserEntity): User {
        return User(
            id = userEntity.id,
            name = userEntity.name,
        )
    }

    fun toEntity(user: User): UserEntity {
        return UserEntity.create(
            name = user.name,
        )
    }
}
