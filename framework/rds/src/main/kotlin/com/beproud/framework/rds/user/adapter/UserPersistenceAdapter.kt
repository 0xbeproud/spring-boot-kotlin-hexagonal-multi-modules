package com.beproud.framework.rds.user.adapter

import com.beproud.application.user.UserNotFoundException
import com.beproud.application.user.port.out.CheckUserPort
import com.beproud.application.user.port.out.DeleteUserPort
import com.beproud.application.user.port.out.RetrieveUserPort
import com.beproud.application.user.port.out.SaveUserPort
import com.beproud.domain.user.User
import com.beproud.framework.rds.user.adapter.mapper.UserMapper
import com.beproud.framework.rds.user.entity.UserRepository
import com.beproud.framework.support.PersistenceAdapter
import org.springframework.data.repository.findByIdOrNull
import java.util.UUID

@PersistenceAdapter
class UserPersistenceAdapter(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper,
) : RetrieveUserPort, CheckUserPort, SaveUserPort, DeleteUserPort {
    override fun retrieveUserById(id: UUID): User {
        val userEntity = userRepository.findByIdOrNull(id) ?: throw UserNotFoundException()
        return userMapper.toDomain(userEntity)
    }

    override fun retrieveUserByName(name: String): User {
        val userEntity = userRepository.findByName(name) ?: throw UserNotFoundException()
        return userMapper.toDomain(userEntity)
    }

    override fun saveUser(user: User) {
        val userEntity = userMapper.toEntity(user)
        userRepository.save(userEntity)
    }

    override fun editUser(user: User) {
        val userEntity = userMapper.toEntity(user)
        userRepository.save(userEntity)
    }

    override fun checkNewUser(user: User) {
    }

    override fun checkEditUser(user: User) {
    }

    override fun checkDeleteUser(user: User) {
    }

    override fun deleteUser(user: User) {
    }
}
