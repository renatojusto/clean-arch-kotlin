package com.arch.infra.adapter.output.persistence

import com.arch.application.port.output.LoadUserPort
import com.arch.application.port.output.SaveUserPort
import com.arch.application.domain.User

class UserPersistenceAdapter(private val userRepository: UserRepository) : SaveUserPort, LoadUserPort {

    override fun registerUser(user: User) {
        val userEntity = UserEntity(name = user.name)
        userRepository.save(userEntity)
    }

    override fun loadUsers(): List<User> {
        return userRepository
            .findAll()
            .map { User(id = it.id, name = it.name) }
    }
}
