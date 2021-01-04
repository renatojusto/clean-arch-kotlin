package com.arch.application.port.input

import com.arch.application.domain.User

interface LoadUsersUseCase {

    fun loadUsers(): List<User>
}
