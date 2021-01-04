package com.arch.infra.adapter.input.web

import com.arch.application.port.input.LoadUsersUseCase
import com.arch.application.port.input.UserRegisterCommand
import com.arch.application.port.input.UserRegisterUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/users")
class UserResource(
    val userRegisterUseCase: UserRegisterUseCase,
    val loadUsersUseCase: LoadUsersUseCase
) {

    @GetMapping("/register")
    fun registerUser(@RequestParam(value = "name", defaultValue = "Teste") name: String) {
        userRegisterUseCase.registerUser(UserRegisterCommand(name))
    }

    @GetMapping
    fun findAllUsers(): List<UserLoadedResponse> {
        return loadUsersUseCase.loadUsers().map { UserLoadedResponse(it.id, it.name) }
    }
}
