package com.arch.infra.adapter.output.persistence

import com.arch.application.domain.User
import com.arch.application.port.output.LoadUserPort
import com.arch.application.port.output.SaveUserPort

class UserPersistenceAdapter(private val userRepository: UserRepository) : SaveUserPort, LoadUserPort {

    override fun registerUser(user: User): User {
        val userEntity = UserEntity(name = user.name)
        val savedUser = userRepository.save(userEntity)
        return User(savedUser.id, savedUser.name)
    }

    override fun loadUsers(): List<User> {
        return userRepository
            .findAll()
            .map { User(id = it.id, name = it.name) }
    }
}
