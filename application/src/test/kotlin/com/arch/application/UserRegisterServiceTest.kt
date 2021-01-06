package com.arch.application

import com.arch.application.domain.User
import com.arch.application.port.input.UserRegisterCommand
import com.arch.application.port.output.EmailNotificationRegisterPort
import com.arch.application.port.output.SaveUserPort
import com.arch.application.port.output.SendConfirmationMailCommand
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.then
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class UserRegisterServiceTest {

    @InjectMocks
    lateinit var userRegisterService: UserRegisterService

    @Mock
    lateinit var saveUserPort: SaveUserPort

    @Mock
    lateinit var emailNotificationRegisterPort: EmailNotificationRegisterPort

    @Test
    fun `registerUser should saved user in repository`() {
        val userRegisterCommand = UserRegisterCommand(name = "Renato")
        val user = User(name = "Renato")
        val sendConfirmationMailCommand = SendConfirmationMailCommand.create(user)

        userRegisterService.registerUser(userRegisterCommand)

        then(saveUserPort).should().registerUser(user)
        then(emailNotificationRegisterPort).should().notifyUserRegistred(sendConfirmationMailCommand)
    }

}
