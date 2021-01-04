package com.arch.application.port.output

import com.arch.application.domain.User

interface LoadUserPort {

    fun loadUsers(): List<User>

}
