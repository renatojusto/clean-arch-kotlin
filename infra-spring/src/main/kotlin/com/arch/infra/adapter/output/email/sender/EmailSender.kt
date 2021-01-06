package com.arch.infra.adapter.output.email.sender

import mu.KotlinLogging
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener

private val logger = KotlinLogging.logger {}

@EnableBinding(EmailSink::class)
class EmailSender {

    @StreamListener(EmailSink.INPUT)
    fun send(log: String) {
        logger.info { "Enviando email: [1]: $log" }
        Thread.sleep(5000)
        logger.info { "Email Enviado!" }
    }
}
