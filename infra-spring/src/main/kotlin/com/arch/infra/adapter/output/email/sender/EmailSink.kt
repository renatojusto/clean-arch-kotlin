package com.arch.infra.adapter.output.email.sender

import org.springframework.cloud.stream.annotation.Input
import org.springframework.messaging.SubscribableChannel

interface EmailSink {
    @Input(INPUT)
    fun input(): SubscribableChannel

    companion object {
        const val INPUT = "inputChannel"
    }
}
