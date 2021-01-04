package com.arch.infra.adapter.output.email

import com.arch.application.domain.User
import com.arch.application.port.output.EmailNotificationPort

class EmailNotificationQueue: EmailNotificationPort {

    override fun send(user: User) {
        println("Enviando E-mail...")
    }
}
