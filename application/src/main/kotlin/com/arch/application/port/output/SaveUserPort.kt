package com.arch.application.port.output

import com.arch.application.domain.User

interface SaveUserPort {

    fun registerUser(user: User): User

}
