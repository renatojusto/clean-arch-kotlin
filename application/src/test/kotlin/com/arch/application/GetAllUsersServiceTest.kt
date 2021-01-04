package com.arch.application

import com.arch.application.domain.User
import com.arch.application.port.output.LoadUserPort
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.then
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import kotlin.test.assertEquals

@ExtendWith(MockitoExtension::class)
class GetAllUsersServiceTest {

    @InjectMocks
    lateinit var loadUsersUseCase: GetAllUsersService

    @Mock
    lateinit var loadUserPort: LoadUserPort

    @Test
    fun `loadUsers should load users from repository`() {
        val user1 = User(name = "User 1")
        val user2 = User(name = "User 2")

        given(loadUserPort.loadUsers()).willReturn(listOf(user1, user2))

        val loadUsers = loadUsersUseCase.loadUsers()

        assertEquals(2, loadUsers.size)
        assertEquals("User 1", loadUsers[0].name)
        assertEquals("User 2", loadUsers[1].name)

        then(loadUserPort).should().loadUsers()
    }

}
