package com.arch.infra.adapter.output.persistence

import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<UserEntity, String>
