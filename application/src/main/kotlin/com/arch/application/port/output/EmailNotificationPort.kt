package com.arch.application.port.output

import com.arch.application.domain.User

interface EmailNotificationPort {

    fun send(user: User)

}
