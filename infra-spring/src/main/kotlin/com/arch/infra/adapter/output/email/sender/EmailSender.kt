package com.arch.infra.adapter.output.email.sender

import mu.KotlinLogging
import org.springframework.amqp.ImmediateAcknowledgeAmqpException
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.messaging.handler.annotation.Header

private val logger = KotlinLogging.logger {}

@EnableBinding(EmailSink::class)
class EmailSender {

    @StreamListener(EmailSink.INPUT)
    fun send(log: String, @Header(name = "x-death", required = false) death: Map<String, Object>?) {
        if (RETRY_TIMES.equals(death?.get("count"))) {
            throw ImmediateAcknowledgeAmqpException("Desistindo da fila")
        }
        logger.info { "Enviando email: [1]: $log" }
        Thread.sleep(5000)
        logger.info { "Email Enviado!" }
    }

    companion object {
        const val RETRY_TIMES = 3L;
    }
}
