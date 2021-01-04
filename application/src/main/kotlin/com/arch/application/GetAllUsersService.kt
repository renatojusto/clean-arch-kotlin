package com.arch.application

import com.arch.application.domain.User
import com.arch.application.port.input.LoadUsersUseCase
import com.arch.application.port.output.LoadUserPort
import com.arch.shared.annotations.UseCase

@UseCase
class GetAllUsersService(private val loadUserPort: LoadUserPort) : LoadUsersUseCase {

    override fun loadUsers(): List<User> {
        return loadUserPort.loadUsers()
    }
}
