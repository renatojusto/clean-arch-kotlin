package com.arch.application.port.output

import com.arch.application.domain.User

data class SendConfirmationMailCommand constructor (val userId: String, val userName: String) {

    companion object {
       fun create(user: User) = SendConfirmationMailCommand(user.id, user.name)
    }

    fun getMessage(): String {
        return "$userName seu cadastro foi realizado com sucesso."
    }

}
