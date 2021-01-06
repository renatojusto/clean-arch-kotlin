package com.arch.application.port.input

import com.arch.application.domain.User

data class UserRegisterCommand(val name: String) {

    fun toUser(): User = User(name = this.name)

}
