package com.arch.application

import com.arch.application.port.input.UserRegisterCommand
import com.arch.application.port.input.UserRegisterUseCase
import com.arch.application.port.output.SaveUserPort
import com.arch.application.domain.User
import com.arch.shared.annotations.UseCase

@UseCase
class UserRegisterService(private val saveUserPort: SaveUserPort) : UserRegisterUseCase {

    override fun registerUser(userRegisterCommand: UserRegisterCommand) {
        println("Registrando usuario: $userRegisterCommand")
        val user = User(name = userRegisterCommand.name)
        saveUserPort.registerUser(user)
    }
}
