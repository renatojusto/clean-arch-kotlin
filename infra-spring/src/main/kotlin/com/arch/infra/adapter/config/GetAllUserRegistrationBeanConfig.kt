package com.arch.infra.adapter.config

import com.arch.application.GetAllUsersService
import com.arch.application.port.input.LoadUsersUseCase
import com.arch.application.port.output.LoadUserPort
import com.arch.infra.adapter.output.persistence.UserPersistenceAdapter
import com.arch.infra.adapter.output.persistence.UserRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GetAllUserRegistrationBeanConfig {

    @Bean
    fun loadUserPort(userRepository: UserRepository): LoadUserPort {
        return UserPersistenceAdapter(userRepository)
    }

    @Bean
    fun getAllUsersService(loadUserPort: LoadUserPort): LoadUsersUseCase {
        return GetAllUsersService(loadUserPort)
    }

}
