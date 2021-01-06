package com.arch.infra.adapter.output.email

import com.arch.infra.SpringApplication
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.fail
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [SpringApplication::class])
@DirtiesContext
internal class EmailSenderTest {

    @Test
    fun `Should send email to channel and the channel consume it`() {
        fail { "Implementar..." }
    }
}
