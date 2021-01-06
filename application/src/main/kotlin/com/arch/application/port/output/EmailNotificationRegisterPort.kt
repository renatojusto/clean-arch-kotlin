package com.arch.application.port.output

interface EmailNotificationRegisterPort {

    fun notifyUserRegistred(sendConfirmationMailCommand: SendConfirmationMailCommand)

}
