package com.arch.application

import com.arch.application.domain.User
import com.arch.application.port.input.UserRegisterCommand
import com.arch.application.port.input.UserRegisterUseCase
import com.arch.application.port.output.EmailNotificationRegisterPort
import com.arch.application.port.output.SaveUserPort
import com.arch.application.port.output.SendConfirmationMailCommand
import com.arch.shared.annotations.UseCase

@UseCase
class UserRegisterService(private val saveUserPort: SaveUserPort,
                          private val emailNotificationRegister: EmailNotificationRegisterPort) : UserRegisterUseCase {

    override fun registerUser(userRegisterCommand: UserRegisterCommand) {
        userRegisterCommand.toUser()
            .apply(saveUserPort::registerUser)
            .apply(::sendEmailForUser)
    }

    private fun sendEmailForUser(newUser: User) {
        SendConfirmationMailCommand.create(newUser)
            .apply(emailNotificationRegister::notifyUserRegistred)
    }
}
