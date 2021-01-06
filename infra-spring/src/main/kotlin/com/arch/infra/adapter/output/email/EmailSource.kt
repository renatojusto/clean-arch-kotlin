package com.arch.infra.adapter.output.email

import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel

interface EmailSource {

    @Output(OUTPUT)
    fun output(): MessageChannel

    companion object {
        const val OUTPUT = "outputChannel"
    }
}
