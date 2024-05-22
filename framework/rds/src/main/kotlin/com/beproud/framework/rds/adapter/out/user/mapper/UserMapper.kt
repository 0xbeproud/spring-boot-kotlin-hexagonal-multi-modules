package com.beproud.framework.rds.adapter.out.user.mapper

import com.beproud.domain.user.User
import com.beproud.framework.rds.entity.user.UserEntity
import com.beproud.framework.rds.support.Mapper

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
