package com.arch.infra.adapter.output.email

import org.springframework.cloud.stream.annotation.Input
import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.SubscribableChannel

interface EmailNotificationBinding {

    @Input(INPUT)
    fun input(): SubscribableChannel

    @Output(OUTPUT)
    fun output(): MessageChannel

    companion object {
        const val INPUT = "emailNotificationInput"
        const val OUTPUT = "emailNotificationOutput"
    }
}
