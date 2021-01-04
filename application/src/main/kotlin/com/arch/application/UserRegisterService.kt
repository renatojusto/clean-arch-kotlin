package com.arch.application

import com.arch.application.domain.User
import com.arch.application.port.input.UserRegisterCommand
import com.arch.application.port.input.UserRegisterUseCase
import com.arch.application.port.output.EmailNotificationPort
import com.arch.application.port.output.SaveUserPort
import com.arch.shared.annotations.UseCase

@UseCase
class UserRegisterService(private val saveUserPort: SaveUserPort,
                          private val emailNotification: EmailNotificationPort) : UserRegisterUseCase {

    override fun registerUser(userRegisterCommand: UserRegisterCommand) {
        val user = User(name = userRegisterCommand.name)
        saveUserPort.registerUser(user)
        emailNotification.send(user)
    }
}
