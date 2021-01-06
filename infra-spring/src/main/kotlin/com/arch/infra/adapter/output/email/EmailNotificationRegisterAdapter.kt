package com.arch.infra.adapter.output.email

import com.arch.application.port.output.EmailNotificationRegisterPort
import com.arch.application.port.output.SendConfirmationMailCommand
import mu.KotlinLogging
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.messaging.support.MessageBuilder

private val logger = KotlinLogging.logger {}

@EnableBinding(EmailSource::class)
class EmailNotificationRegisterAdapter (private val emailSource: EmailSource): EmailNotificationRegisterPort {

    override fun notifyUserRegistred(sendConfirmationMailCommand: SendConfirmationMailCommand) {
        logger.info { "Enviando E-mail do usuário: ${sendConfirmationMailCommand.userId} para a fila" }
        this.emailSource
            .output()
            .send(MessageBuilder.withPayload(sendConfirmationMailCommand.getMessage()).build())
    }
}
