package com.arch.infra.adapter.config

import com.arch.application.UserRegisterService
import com.arch.application.port.input.UserRegisterUseCase
import com.arch.application.port.output.SaveUserPort
import com.arch.infra.adapter.output.persistence.UserPersistenceAdapter
import com.arch.infra.adapter.output.persistence.UserRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UserRegistrationBeanConfig {

    @Bean
    fun newSaveUserPort(userRepository: UserRepository): SaveUserPort {
        return UserPersistenceAdapter(userRepository)
    }

    @Bean
    fun newUserRegistrationUseCase(saveUserPort: SaveUserPort): UserRegisterUseCase {
        return UserRegisterService(saveUserPort)
    }

}
